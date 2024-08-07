package com.social.gateway.controller;

import com.social.gateway.service.contract.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ApiGatewayController {

    private final AuthenticationService authenticationService;

    @PostMapping("/")
    public String authenticate(@RequestParam("email") String email,
                               @RequestParam("password") String password) {
        return authenticationService.login(email, password);
    }

    @GetMapping("/health")
    public String health() {
        return "API Gateway service is HEALTHY.";
    }
}
