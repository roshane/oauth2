package com.aeon.oauth2.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.exceptions.UnauthorizedClientException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@RestController
public class ClientResource {

    private static final Logger logger = LoggerFactory.getLogger("CONSOLE");

    @GetMapping("/info")
    public Map<String, String> info() {
        return Collections.singletonMap("version", "1.0.0");
    }

    @GetMapping("/user")
    public ResponseEntity<?> user(Principal principal) {
        logger.info("class {}", principal.getClass().getName());
        Authentication authentication = Optional.of(principal)
                .filter(p -> p instanceof OAuth2Authentication)
                .map(OAuth2Authentication.class::cast)
                .map(OAuth2Authentication::getUserAuthentication)
                .orElseThrow(() -> new UnauthorizedClientException("client is not authorized"));
        return ResponseEntity.ok(authentication);
    }
}
