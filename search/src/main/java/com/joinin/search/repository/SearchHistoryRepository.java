package com.joinin.search.repository;

import com.joinin.search.model.mongo.KeywordsHistoryEntry;
import com.joinin.search.model.mongo.SearchHistoryEntry;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SearchHistoryRepository {

    private final MongoTemplate mongoTemplate;

    public SearchHistoryEntry save(SearchHistoryEntry searchHistoryEntry) {
        return mongoTemplate.save(searchHistoryEntry);
    }

    public List<String> retrieveProfileSearchKeywords(String identity) {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("profileIdentity").is(identity)),
                Aggregation.unwind("history"),
                Aggregation.sort(Sort.Direction.DESC, "history.searchedAt"),
                Aggregation.replaceRoot("history"));

        return mongoTemplate.aggregate(aggregation, "search_history", KeywordsHistoryEntry.class)
                .getMappedResults()
                .stream()
                .map(KeywordsHistoryEntry::getKeyword)
                .toList();
    }
}
