package com.joinin.search.mapper;

import com.join_in.common_models.KeywordsHistoryRpSearchService;
import com.join_in.common_models.SearchHistoryRpSearchService;
import com.joinin.search.model.mongo.KeywordsHistoryEntry;
import com.joinin.search.model.mongo.SearchHistoryEntry;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SearchHistoryMapper {
    SearchHistoryRpSearchService fromSearchHistoryEntrytoSearchHistoryRpSearchService(SearchHistoryEntry source);

    KeywordsHistoryRpSearchService fromKeywordsHistoryEntrytoKeywordsHistoryRpSearchService(KeywordsHistoryEntry source);
}
