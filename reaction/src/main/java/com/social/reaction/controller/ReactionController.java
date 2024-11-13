package com.social.reaction.controller;

import com.social.reaction.service.contract.PostService;
import com.social.reaction.service.contract.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ReactionController {

    private final ProfileService profileService;

    @GetMapping("/post/{identity}/likes")
    public int findPostLikesCount(@PathVariable("identity") String identity) {
        return profileService.findPostLikesCount(identity);
    }

    @GetMapping("/health")
    public String health() {
        return "Reaction service is HEALTHY!";
    }
}
