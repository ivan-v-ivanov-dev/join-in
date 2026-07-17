package com.joinin.search.repository;

import com.joinin.search.model.SearchHistoryEntry;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SearchHistoryRepository {

    private final MongoTemplate mongoTemplate;

    public SearchHistoryEntry save(SearchHistoryEntry searchHistoryEntry) {
        return mongoTemplate.save(searchHistoryEntry);
    }
}
