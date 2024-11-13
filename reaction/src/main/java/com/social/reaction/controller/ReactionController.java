package com.social.reaction.controller;

import com.social.reaction.service.contract.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@AllArgsConstructor
public class ReactionController {

    private final ProfileService profileService;

    @GetMapping("/post/{postIdentity}/likes")
    public int findPostLikesCount(@PathVariable("postIdentity") String postIdentity) {
        return profileService.findPostLikesCount(postIdentity);
    }

    @GetMapping("/post/{postIdentity}/dislikes")
    public int findPostDislikesCount(@PathVariable("postIdentity") String postIdentity) {
        return profileService.findPostDislikesCount(postIdentity);
    }

    @GetMapping("/post/{postIdentity}/stars")
    public int findPostStarsCount(@PathVariable("postIdentity") String postIdentity) {
        return profileService.findPostStarsCount(postIdentity);
    }

    @GetMapping("/post/{postIdentity}/likes/profile-identities")
    public Set<String> findProfileIdentitiesWhoLikedThePost(@PathVariable("postIdentity") String postIdentity) {
        return profileService.findProfileIdentitiesWhoLikedThePost(postIdentity);
    }
    @GetMapping("/post/{postIdentity}/dislikes/profile-identities")
    public Set<String> findProfileIdentitiesWhoDislikedThePost(@PathVariable("postIdentity") String postIdentity) {
        return profileService.findProfileIdentitiesWhoDislikedThePost(postIdentity);
    }

    @GetMapping("/health")
    public String health() {
        return "Reaction service is HEALTHY!";
    }
}
