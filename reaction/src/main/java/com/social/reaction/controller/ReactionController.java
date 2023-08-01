package com.social.reaction.controller;

import com.social.reaction.service.contracts.ProfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

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

    @PostMapping("/comment/likes")
    public int findLikesACommentProfileCount(@RequestParam("commentIdentity") String commentIdentity) {
        return profileService.findLikesACommentProfileCount(commentIdentity);
    }

    @PostMapping("/post/dislikes")
    public int findDislikesAPostProfileCount(@RequestParam("postIdentity") String postIdentity) {
        return profileService.findDislikesAPostProfileCount(postIdentity);
    }

    @PostMapping("/comment/dislikes")
    public int findDislikesACommentProfileCount(@RequestParam("commentIdentity") String commentIdentity) {
        return profileService.findDislikesACommentProfileCount(commentIdentity);
    }

    @PostMapping("/post/stars")
    public int findStarsAPostProfileCount(@RequestParam("postIdentity") String postIdentity) {
        return profileService.findStarsAPostProfileCount(postIdentity);
    }

    @PostMapping("/post/reactions/users")
    public Set<String> findPeopleWhoReactedToPost(@RequestParam("postIdentity") String postIdentity) {
        return profileService.findPeopleWhoReactedToPost(postIdentity);
    }

    @PostMapping("/post/likes/users")
    public Set<String> findPeopleWhoLikedThePost(@RequestParam("postIdentity") String postIdentity) {
        return profileService.findPeopleWhoLikedThePost(postIdentity);
    }

    @PostMapping("/post/dislikes/users")
    public Set<String> findPeopleWhoDislikedThePost(@RequestParam("postIdentity") String postIdentity) {
        return profileService.findPeopleWhoDislikedThePost(postIdentity);
    }

    @PostMapping("/post/stars/users")
    public Set<String> findPeopleWhoStaredThePost(@RequestParam("postIdentity") String postIdentity) {
        return profileService.findPeopleWhoStaredThePost(postIdentity);
    }

    @GetMapping("/health")
    public String health() {
        return "Reaction service is HEALTHY!";
    }
}
