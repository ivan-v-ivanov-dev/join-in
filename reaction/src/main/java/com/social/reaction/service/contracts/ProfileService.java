package com.social.reaction.service.contracts;

public interface ProfileService {

    int findLikesAPostProfileCount(String postIdentity);

    int findDislikesAPostProfileCount(String postIdentity);

    int findStarsAPostProfileCount(String postIdentity);
}
