package com.social.relationship.service.contracts;

import com.social.relationship.model.Profile;

import java.util.List;

public interface ProfileService {

    List<Profile> findFriendsByProfileIdentity(String identity);

    void save(Profile profile);

    int findFriendCountByProfileIdentity(String identity);
}
