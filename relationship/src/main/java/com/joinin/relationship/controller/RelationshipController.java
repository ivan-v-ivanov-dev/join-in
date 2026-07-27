package com.joinin.relationship.controller;

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
}
