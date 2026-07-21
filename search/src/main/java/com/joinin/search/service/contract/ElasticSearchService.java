package com.joinin.search.service.contract;

public interface ElasticSearchService {
    void saveProfile(String identity, String firstName, String lastName);
}
