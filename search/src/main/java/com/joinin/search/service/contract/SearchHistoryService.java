package com.joinin.search.service.contract;

import java.util.List;

public interface SearchHistoryService {
    void saveProfileSearchHistory(String identity);

    List<String> retrieveProfileSearchKeywords(String identity);
}
