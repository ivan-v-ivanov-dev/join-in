package com.joinin.post.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @GetMapping
    public String health() {
        return "Post service is HEALTHY";
    }
}
