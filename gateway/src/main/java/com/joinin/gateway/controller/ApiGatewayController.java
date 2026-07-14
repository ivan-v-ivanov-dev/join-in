package com.joinin.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiGatewayController {

    @GetMapping("/health")
    public String health() {
        return "API Gateway service is HEALTHY.";
    }
}
