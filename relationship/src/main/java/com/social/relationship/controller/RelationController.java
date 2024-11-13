package com.social.relationship.controller;

import com.social.relationship.service.contract.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@AllArgsConstructor
public class RelationController {

    private final ProfileService profileService;

    @GetMapping("/profile/{identity}/friends")
    public Set<String> findFriends(@PathVariable("identity") String identity) {
        return profileService.findFriendsByProfileIdentity(identity);
    }

    @GetMapping("/health")
    public String health() {
        return "Relation service is HEALTHY!";
    }
}
