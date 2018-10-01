package com.aeon.oauth2.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("com.aeon.oauth2.server.repository")
public class RepositoryConfig {

}
