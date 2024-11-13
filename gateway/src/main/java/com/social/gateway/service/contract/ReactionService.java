package com.social.gateway.service.contract;

import java.util.Set;

public interface ReactionService {
    int findPostLikesCount(String postIdentity);

    Set<String> findProfileIdentitiesWhoLikedThePost(String postIdentity);
}
