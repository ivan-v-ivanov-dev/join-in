package com.social.post.repository.contract;

import com.social.post.model.Post;

public interface PostRepository {
    void createCollection(String collection);

    Post findByAuthorIdentityAndPostIdentity(String postIdentity, String collection);
}
