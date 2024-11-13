package com.social.post.repository.contract;

import com.social.post.model.Post;

import java.util.List;

public interface PostRepository {
    void createCollection(String collection);

    Post findByAuthorIdentityAndPostIdentity(String postIdentity, String collection);

    List<Post> findPostsByAuthorIdentity(String collection);
}
