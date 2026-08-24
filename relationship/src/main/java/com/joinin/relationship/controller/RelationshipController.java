package com.joinin.relationship.controller;

import com.join_in.common_models.FamilyMemberRpRelationshipService;
import com.join_in.common_models.ProfileRpRelationshipService;
import com.joinin.relationship.service.contract.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class RelationshipController {

    private final ProfileService profileService;

    @GetMapping("/profile/{identity}/friends")
    public List<ProfileRpRelationshipService> retrieveFriendsProfiles(@PathVariable String identity) {
        return profileService.retrieveFriendsProfiles(identity);
    }

    @GetMapping("/profile/{identity}/friend/suggestions")
    public List<ProfileRpRelationshipService> retrieveFriendSuggestions(@PathVariable String identity) {
        return profileService.retrieveFriendSuggestions(identity);
    }

    @GetMapping("/profile/{identity}/frienship/requests")
    public List<ProfileRpRelationshipService> retrieveFriendshipRequests(@PathVariable String identity) {
        return profileService.retrieveFriendshipRequests(identity);
    }

    @GetMapping("/profile/{identity}/friends/count")
    public int retrieveProfilesFriendsCount(@PathVariable String identity) {
        return profileService.retrieveProfilesFriendsCount(identity);
    }

    @GetMapping("/profile/{identity}/family/members")
    public List<FamilyMemberRpRelationshipService> retrieveProfileFamilyMembers(@PathVariable String identity) {
        return profileService.retrieveProfileFamilyMembers(identity);
    }
}
