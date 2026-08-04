package com.joinin.search.controller;

import com.joinin.search.service.contract.SearchHistoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class SearchController {

    private final SearchHistoryService searchHistoryService;

    @GetMapping("/profile/{identity}")
    public List<String> retrieveProfileSearchHistory(@PathVariable String identity) {
        return searchHistoryService.retrieveProfileSearchKeywords(identity);
    }
}
