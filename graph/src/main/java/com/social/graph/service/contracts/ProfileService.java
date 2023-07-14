package com.social.graph.service.contracts;

import com.social.graph.model.Profile;

import java.util.List;

public interface ProfileService {
    Profile findByIdentity(String identity);

    List<Profile> findFriendsByProfileIdentity(String identity);

    long findLikesAPostProfileCount(String postIdentity);

    long findDislikesAPostProfileCount(String postIdentity);

    long findStarsAPostProfileCount(String postIdentity);
}
