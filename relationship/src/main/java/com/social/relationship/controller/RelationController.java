package com.social.relationship.controller;

import com.social.relationship.service.contracts.ProfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RelationController {

    private final ProfileService profileService;

    public RelationController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/profile/friends")
    public List<String> findFriends(@RequestParam("identity") String identity) {
        return profileService.findFriendsByProfileIdentity(identity);
    }

    @PostMapping("/profile/friends/count")
    public int findFriendCount(@RequestParam("identity") String identity) {
        return profileService.findFriendCountByProfileIdentity(identity);
    }

    @GetMapping("/health")
    public String health() {
        return "Relation service is HEALTHY!";
    }
}
