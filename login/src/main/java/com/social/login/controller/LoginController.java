package com.social.login.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/health")
    public String health() {
        return "Login service is HEALTHY.";
    }
}
