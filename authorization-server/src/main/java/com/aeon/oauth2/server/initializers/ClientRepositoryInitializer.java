package com.aeon.oauth2.server.initializers;

import com.aeon.oauth2.server.model.OauthClient;
import com.aeon.oauth2.server.repository.OauthClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class ClientRepositoryInitializer implements CommandLineRunner {


    @Autowired
    private OauthClientRepository clientRepository;

    @Override
    public void run(String... args) throws Exception {
        if (clientRepository.count() == 0) {
            Stream.of("client01,secret01", "client02,secret02")
                    .map(s -> s.split(","))
                    .map(ar -> new OauthClient(ar[0], ar[1]))
                    .forEach(clientRepository::save);
        }
    }
}
