package com.aeon.oauth2.server.repository;

import com.aeon.oauth2.Oauth2ApplicationTestBase;
import com.aeon.oauth2.server.model.OauthClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class OauthClientRepositoryTest extends Oauth2ApplicationTestBase {

    @Autowired
    private OauthClientRepository clientRepository;

    @Test
    public void contextLoad() {
        assertNotNull(clientRepository);
    }

    @Before
    public void insertClients() {
        Stream.of("client01,secret01", "client02,secret02")
                .map(s -> s.split(","))
                .map(ar -> new OauthClient(ar[0], ar[1]))
                .forEach(clientRepository::save);
    }

    @After
    public void deleteClients(){
        clientRepository.deleteAll();
    }

    @Test
    public void findAllClients(){
        List<OauthClient> clients = clientRepository.findAll();
        assertNotNull(clients);
        assertEquals(2,clients.size());
    }
}