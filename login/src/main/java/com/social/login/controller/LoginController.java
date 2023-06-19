package com.social.login.controller;

import com.social.login.service.contract.LoginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/")
    public void login() {
        this.loginService.login();
    }

    @GetMapping("/health")
    public String health() {
        return "Login service is HEALTHY.";
    }
}
