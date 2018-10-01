package com.aeon.oauth2.server.config;

import com.aeon.oauth2.Oauth2ApplicationTestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.junit.Assert.*;

public class CustomAuthorizationServerConfigTest extends Oauth2ApplicationTestBase {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void contextLoads() {
        assertNotNull(mongoTemplate);
        assertEquals("hrm", applicationProperties.getClientId());
    }


}