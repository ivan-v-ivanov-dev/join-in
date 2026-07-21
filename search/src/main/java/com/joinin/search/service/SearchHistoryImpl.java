package com.joinin.search.service;

import com.joinin.search.model.mongo.SearchHistoryEntry;
import com.joinin.search.repository.SearchHistoryRepository;
import com.joinin.search.service.contract.SearchHistory;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class SearchHistoryImpl implements SearchHistory {

    private final SearchHistoryRepository searchHistoryRepository;

    @Override
    public void saveProfileSearchHistory(String identity) {
        SearchHistoryEntry saved = searchHistoryRepository.save(SearchHistoryEntry.builder().identity(identity).build());
        log.info("New search history entry saved with profile identity: " + saved.getIdentity());
    }
}
