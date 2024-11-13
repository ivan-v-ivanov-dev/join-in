package com.social.gateway.service.contract;

import java.util.Set;

public interface ReactionService {
    int findPostLikesCount(String postIdentity);

    int findPostDislikesCount(String postIdentity);

    int findPostStarsCount(String postIdentity);

    Set<String> findProfileIdentitiesWhoLikedThePost(String postIdentity);

    Set<String> findProfileIdentitiesWhoDislikedThePost(String postIdentity);

    Set<String> findProfileIdentitiesWhoStaredThePost(String postIdentity);

    int findCommentsLikesCount(String commentIdentity);

    int findCommentDislikesCount(String commentIdentity);
}
