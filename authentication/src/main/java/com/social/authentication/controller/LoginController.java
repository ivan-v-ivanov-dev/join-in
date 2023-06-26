package com.social.authentication.controller;

import com.social.authentication.service.contract.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @PostMapping("/")
    public String authenticate(@RequestParam("email") String email, @RequestParam("password") String password) {
        try {
            loginService.login(email, password);
            return "Redirect to Profile Service";
        } catch (IllegalArgumentException illegalArgumentException) {
            return "redirect:/";
        }
    }

    @GetMapping("/health")
    public String health() {
        return "Login service is HEALTHY.";
    }
}
