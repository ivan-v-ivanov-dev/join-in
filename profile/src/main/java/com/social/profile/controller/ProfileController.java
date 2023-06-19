package com.social.profile.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @PostMapping("/profile")
    public String profile(@RequestParam("identity") String identity) {
        return "In Profile Service";
    }

    @GetMapping("/health")
    public String health() {
        return "Profile service is HEALTHY.";
    }
}
