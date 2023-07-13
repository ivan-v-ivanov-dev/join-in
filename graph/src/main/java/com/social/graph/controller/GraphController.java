package com.social.graph.controller;

import com.social.graph.model.Profile;
import com.social.graph.service.contracts.ProfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GraphController {

    private final ProfileService profileService;

    public GraphController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/")
    public Profile profiles(@RequestParam("identity") String identity) {
        return profileService.findByIdentity(identity);
    }

    @GetMapping("/health")
    public String health() {
        return "Graph service is HEALTHY!";
    }
}
