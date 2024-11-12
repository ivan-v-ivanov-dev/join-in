package com.social.post.service.contract;

import com.social.post.model.Post;

public interface PostService {
    void createCollection(String identity);

    Post findByAuthorIdentityAndPostIdentity(String authorIdentity, String postIdentity);
}
