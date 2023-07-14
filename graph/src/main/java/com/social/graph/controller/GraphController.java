package com.social.graph.controller;

import com.social.graph.model.Profile;
import com.social.graph.service.contracts.ProfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GraphController {

    private final ProfileService profileService;

    public GraphController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/")
    public Profile profile(@RequestParam("identity") String identity) {
        return profileService.findByIdentity(identity);
    }

    @PostMapping("/friends")
    public List<Profile> findFriends(@RequestParam("identity") String identity) {
        return profileService.findFriendsByProfileIdentity(identity);
    }

    @PostMapping("/post/likes")
    public long findLikesAPostProfileCount(@RequestParam("postIdentity") String postIdentity) {
        return profileService.findLikesAPostProfileCount(postIdentity);
    }

    @PostMapping("/post/dislikes")
    public long findDislikesAPostProfileCount(@RequestParam("postIdentity") String postIdentity) {
        return profileService.findDislikesAPostProfileCount(postIdentity);
    }

    @PostMapping("/post/stars")
    public long findStarsAPostProfileCount(@RequestParam("postIdentity") String postIdentity) {
        return profileService.findStarsAPostProfileCount(postIdentity);
    }

    @GetMapping("/health")
    public String health() {
        return "Graph service is HEALTHY!";
    }
}
