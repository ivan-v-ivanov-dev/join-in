package com.social.relationship.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RelationController {

    @GetMapping("/health")
    public String health() {
        return "Relation service is HEALTHY!";
    }
}
