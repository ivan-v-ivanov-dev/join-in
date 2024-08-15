package com.social.profile.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @GetMapping("/health")
    public String health() {
        return "Profile service is HEALTHY.";
    }
}
