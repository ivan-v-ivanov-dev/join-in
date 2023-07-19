package com.social.post.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    @GetMapping("/health")
    public String health() {
        return "Notification service is HEALTHY";
    }
}
