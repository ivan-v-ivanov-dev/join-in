package com.social.model.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {

    @GetMapping("/health")
    public String health() {
        return "Image service is HEALTHY";
    }
}
