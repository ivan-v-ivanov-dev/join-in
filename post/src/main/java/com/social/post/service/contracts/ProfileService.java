package com.social.post.service.contracts;

import java.util.Set;

public interface ProfileService {
    Set<String> findAllUsersCommentingThePost(String postIdentity, String authorIdentity);
}
