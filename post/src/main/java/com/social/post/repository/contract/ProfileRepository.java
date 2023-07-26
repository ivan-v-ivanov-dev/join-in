package com.social.post.repository.contract;

import java.util.Set;

public interface ProfileRepository {
    Set<String> findAllUsersCommentingThePost(String postIdentity, String collection);
}
