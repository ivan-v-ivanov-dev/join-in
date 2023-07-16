package com.social.relationship.controller;

import com.social.relationship.service.contracts.ProfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RelationController {

    private final ProfileService profileService;

    public RelationController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/post/likes")
    public int findLikesAPostProfileCount(@RequestParam("postIdentity") String postIdentity) {
        return profileService.findLikesAPostProfileCount(postIdentity);
    }

    @PostMapping("/post/dislikes")
    public int findDislikesAPostProfileCount(@RequestParam("postIdentity") String postIdentity) {
        return profileService.findDislikesAPostProfileCount(postIdentity);
    }

    @PostMapping("/post/stars")
    public int findStarsAPostProfileCount(@RequestParam("postIdentity") String postIdentity) {
        return profileService.findStarsAPostProfileCount(postIdentity);
    }

    @GetMapping("/health")
    public String health() {
        return "Graph service is HEALTHY!";
    }
}
