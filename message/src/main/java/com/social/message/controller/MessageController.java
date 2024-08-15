package com.social.message.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @GetMapping("/health")
    public String health() {
        return "Message service is HEALTHY";
    }
}
