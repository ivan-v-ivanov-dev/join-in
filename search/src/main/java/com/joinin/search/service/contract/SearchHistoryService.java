package com.joinin.search.service.contract;

import com.join_in.common_models.SearchHistoryRpSearchService;

public interface SearchHistoryService {
    void saveProfileSearchHistory(String identity);

    SearchHistoryRpSearchService retrieveProfileSearchHistory(String identity);
}
