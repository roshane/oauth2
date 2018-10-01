package com.aeon.oauth2.server.model;

import lombok.*;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class OauthClient {
    @Id
    private String id;
    private String clientId;
    private String clientSecret;

    public OauthClient(String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }
}
