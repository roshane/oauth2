package com.aeon.oauth2.server.controller;

import com.aeon.oauth2.server.model.OauthClient;
import com.aeon.oauth2.server.repository.OauthClientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final OauthClientRepository oauthClientRepository;

    public AdminController(OauthClientRepository oauthClientRepository) {
        this.oauthClientRepository = oauthClientRepository;
    }

    @GetMapping("/clients")
    public ResponseEntity<List<OauthClient>> clients() {
        return ResponseEntity.ok(oauthClientRepository.findAll());
    }
}
