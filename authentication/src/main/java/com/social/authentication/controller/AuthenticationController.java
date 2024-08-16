package com.social.authentication.controller;

import com.social.authentication.service.contract.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthenticationController {

    private final LoginService loginService;

    @PostMapping("/")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password) {
        return loginService.login(email, password);
    }

    @GetMapping("/health")
    public String health() {
        return "Login service is HEALTHY.";
    }
}
