package com.joinin.search.controller;

import com.join_in.common_models.SearchHistoryRpSearchService;
import com.joinin.search.service.contract.SearchHistoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SearchController {

    private final SearchHistoryService searchHistoryService;

    @GetMapping("/profile/{identity}")
    public SearchHistoryRpSearchService retrieveProfileSearchHistory(@PathVariable String identity) {
        return searchHistoryService.retrieveProfileSearchHistory(identity);
    }
}
