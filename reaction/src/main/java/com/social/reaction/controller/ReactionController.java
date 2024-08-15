package com.social.reaction.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReactionController {

    @GetMapping("/health")
    public String health() {
        return "Reaction service is HEALTHY!";
    }
}
