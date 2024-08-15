package com.social.gateway.controller;

import com.social.gateway.service.contract.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ApiGatewayController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password) {
        return authenticationService.login(email, password);
    }

    @PostMapping("/register")
    public void register(@RequestParam("email") String email,
                         @RequestParam("password") String password) {
        authenticationService.register(email, password);
    }

    @GetMapping("/health")
    public String health() {
        return "API Gateway service is HEALTHY.";
    }
}
