package com.joinin.group.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupController {

    @GetMapping("/health")
    public String health() {
        return "Group service is HEALTHY";
    }
}
