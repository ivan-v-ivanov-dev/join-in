package com.social.reaction.service.contract;

import java.util.Set;

public interface ProfileService {
    void createProfile(String identity);

    int findPostLikesCount(String postIdentity);

    int findPostDislikesCount(String postIdentity);

    int findPostStarsCount(String postIdentity);
    
    Set<String> findProfileIdentitiesWhoLikedThePost(String postIdentity);

    Set<String> findProfileIdentitiesWhoDislikedThePost(String postIdentity);

    Set<String> findProfileIdentitiesWhoStaredThePost(String postIdentity);

    int findCommentLikesCount(String commentIdentity);

    int findCommentDislikesCount(String commentIdentity);
}
