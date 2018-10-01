package com.aeon.oauth2.server.repository;

import com.aeon.oauth2.server.model.OauthClient;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OauthClientRepository extends PagingAndSortingRepository<OauthClient, String> {

    List<OauthClient> findAll();
}
