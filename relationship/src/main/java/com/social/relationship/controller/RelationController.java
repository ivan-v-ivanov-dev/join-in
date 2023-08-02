package com.social.relationship.controller;

import com.social.relationship.model.Friend;
import com.social.relationship.model.FriendSuggestion;
import com.social.relationship.model.FriendshipRequest;
import com.social.relationship.service.contracts.ProfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class RelationController {

    private final ProfileService profileService;

    public RelationController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/profile/friends")
    public Set<Friend> findFriends(@RequestParam("identity") String identity) {
        return profileService.findFriendsByProfileIdentity(identity);
    }

    @PostMapping("/profile/friends/count")
    public int findFriendCount(@RequestParam("identity") String identity) {
        return profileService.findFriendCountByProfileIdentity(identity);
    }

    @PostMapping("/profile/friendship/requests")
    public List<FriendshipRequest> findFriendshipRequests(@RequestParam("identity") String identity) {
        return profileService.findFriendshipRequest(identity);
    }

    @PostMapping("/profile/friendship/requests/count")
    public int findFriendshipRequestsCount(@RequestParam("identity") String identity) {
        return profileService.findFriendshipRequestCountByProfileIdentity(identity);
    }

    @PostMapping("/profile/friend/suggestions")
    public List<FriendSuggestion> findFriendSuggestions(@RequestParam("identity") String identity) {
        return profileService.findFriendSuggestions(identity);
    }

    @GetMapping("/health")
    public String health() {
        return "Relation service is HEALTHY!";
    }
}
