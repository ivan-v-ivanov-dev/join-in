package com.joinin.search.service;

import com.join_in.common_models.SearchHistoryRpSearchService;
import com.joinin.search.mapper.SearchHistoryMapper;
import com.joinin.search.model.mongo.SearchHistoryEntry;
import com.joinin.search.repository.SearchHistoryRepository;
import com.joinin.search.service.contract.SearchHistoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SearchHistoryServiceImpl implements SearchHistoryService {

    private final SearchHistoryRepository searchHistoryRepository;
    private final SearchHistoryMapper searchHistoryMapper;

    @Override
    public void saveProfileSearchHistory(String identity) {
        SearchHistoryEntry saved = searchHistoryRepository.save(SearchHistoryEntry.builder().identity(identity).build());
        log.info("New search history entry saved with profile identity: " + saved.getIdentity());
    }

    @Override
    public SearchHistoryRpSearchService retrieveProfileSearchHistory(String identity) {
        SearchHistoryEntry searchHistoryEntry = searchHistoryRepository.retrieveProfileSearchHistory(identity);
        log.info("Retrieve search history for profile: " + identity);
        return searchHistoryMapper.fromSearchHistoryEntrytoSearchHistoryRpSearchService(searchHistoryEntry);
    }
}
