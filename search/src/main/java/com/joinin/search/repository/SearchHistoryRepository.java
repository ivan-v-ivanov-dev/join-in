package com.joinin.search.repository;

import com.joinin.search.model.mongo.SearchHistoryEntry;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SearchHistoryRepository {

    private final MongoTemplate mongoTemplate;

    public SearchHistoryEntry save(SearchHistoryEntry searchHistoryEntry) {
        return mongoTemplate.save(searchHistoryEntry);
    }

    public SearchHistoryEntry retrieveProfileSearchHistory(String identity) {
        Query query = Query.query(Criteria.where("identity").is(identity));
        return mongoTemplate.findOne(query, SearchHistoryEntry.class);
    }
}
