package com.social.relationship.service.contracts;

import com.social.relationship.model.Friend;
import com.social.relationship.model.Profile;

import java.util.Set;

public interface ProfileService {

    Set<Friend> findFriendsByProfileIdentity(String identity);

    void save(Profile profile);

    int findFriendCountByProfileIdentity(String identity);
}
