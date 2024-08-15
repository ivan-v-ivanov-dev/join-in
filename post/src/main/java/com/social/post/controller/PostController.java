package com.social.post.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @GetMapping("/health")
    public String health() {
        return "Post service is HEALTHY";
    }
}
