package com.social.reaction.service.contracts;

import com.social.reaction.model.Profile;

import java.util.Set;

public interface ProfileService {

    int findLikesAPostProfileCount(String postIdentity);

    int findLikesACommentProfileCount(String commentIdentity);

    int findDislikesAPostProfileCount(String postIdentity);

    int findDislikesACommentProfileCount(String commentIdentity);

    int findStarsAPostProfileCount(String postIdentity);

    void save(Profile profile);

    Set<String> findPeopleWhoReactedToPost(String postIdentity);

    Set<String> findPeopleWhoLikedThePost(String postIdentity);
}
