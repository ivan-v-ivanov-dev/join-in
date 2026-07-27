package com.joinin.relationship.service.contract;

import com.join_in.common_models.ProfileRpRelationshipService;

import java.util.List;

public interface ProfileService {
    void createProfile(String identity);

    List<ProfileRpRelationshipService> retrieveFriendsProfiles(String identity);
}
