package com.social.reaction.controller;

import com.social.reaction.service.contracts.ProfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReactionController {

    private final ProfileService profileService;

    public ReactionController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/post/likes")
    public int findLikesAPostProfileCount(@RequestParam("postIdentity") String postIdentity) {
        return profileService.findLikesAPostProfileCount(postIdentity);
    }

    @GetMapping("/health")
    public String health() {
        return "Reaction service is HEALTHY!";
    }
}