package com.social.graph.service.contracts;

import com.social.graph.model.Profile;

import java.util.List;

public interface ProfileService {
    Profile findByIdentity(String identity);

    List<Profile> findFriendsByProfileIdentity(String identity);

    int findLikesAPostProfileCount(String postIdentity);

    int findDislikesAPostProfileCount(String postIdentity);

    int findStarsAPostProfileCount(String postIdentity);
}
