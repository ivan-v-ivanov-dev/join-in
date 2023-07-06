package com.social.authentication.controller;

import com.social.authentication.service.contract.LoginService;
import com.social.authentication.service.contract.RegisterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private final LoginService loginService;
    private final RegisterService registerService;

    public AuthenticationController(LoginService loginService,
                                    RegisterService registerService) {
        this.loginService = loginService;
        this.registerService = registerService;
    }

    @PostMapping("/")
    public String authenticate(@RequestParam("email") String email,
                               @RequestParam("password") String password) {
        return loginService.login(email, password);
    }

    @GetMapping("/health")
    public String health() {
        return "Login service is HEALTHY.";
    }
}
