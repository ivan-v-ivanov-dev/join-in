package com.joinin.marketplace.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarketplaceController {

    @GetMapping("/health")
    public String health() {
        return "Marketplace Service is healthy";
    }
}
