package com.social.relationship.service.contracts;

import com.social.relationship.model.Profile;

import java.util.List;

public interface ProfileService {
    Profile findByIdentity(String identity);

    List<Profile> findFriendsByProfileIdentity(String identity);

    int findLikesAPostProfileCount(String postIdentity);

    int findDislikesAPostProfileCount(String postIdentity);

    int findStarsAPostProfileCount(String postIdentity);

    void save(Profile profile);
}
