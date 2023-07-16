package com.social.reaction.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GraphController {

    @GetMapping("/health")
    public String health() {
        return "Graph service is HEALTHY!";
    }
}
