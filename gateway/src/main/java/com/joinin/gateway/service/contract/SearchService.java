package com.joinin.gateway.service.contract;

import java.util.List;

public interface SearchService {
    List<String> retrieveProfileSearchKeywords(String identity);
}
