package com.joinin.mvc.service;

import com.joinin.mvc.service.contract.SearchService;
import com.joinin.mvc.service.feign.GatewayClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SearchServiceImpl implements SearchService {

    private final GatewayClient gatewayClient;

    @Override
    public List<String> retrieveProfileSearchKeywords(String identity) {
        List<String> keywords = gatewayClient.retrieveProfileSearchKeywords(identity);
        log.info("Retrieve profile search keywords. Profile: " + identity);
        return keywords;
    }
}
