package com.social.reaction.service.contracts;

import com.social.reaction.model.Profile;

public interface ProfileService {

    int findLikesAPostProfileCount(String postIdentity);

    int findDislikesAPostProfileCount(String postIdentity);

    int findStarsAPostProfileCount(String postIdentity);

    void save(Profile profile);
}
