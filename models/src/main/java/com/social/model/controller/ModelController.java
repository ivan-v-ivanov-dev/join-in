package com.social.model.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModelController {

    @GetMapping("/health")
    public String health() {
        return "Model service is HEALTHY";
    }
}
