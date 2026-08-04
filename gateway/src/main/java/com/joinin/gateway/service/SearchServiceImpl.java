package com.joinin.gateway.service;

import com.joinin.gateway.service.contract.SearchService;
import com.joinin.gateway.service.feign.SearchServiceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SearchServiceImpl implements SearchService {

    private final SearchServiceClient searchServiceClient;

    @Override
    public List<String> retrieveProfileSearchKeywords(String identity) {
        List<String> keywords = searchServiceClient.retrieveProfileSearchHistory(identity);
        log.info("Retrieve profile search keywords from Search service. Profile identity: " + identity);
        return keywords;
    }
}
