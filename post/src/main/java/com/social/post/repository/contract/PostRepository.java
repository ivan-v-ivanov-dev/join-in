package com.social.post.repository.contract;

import com.social.post.model.Post;

import java.util.List;

public interface PostRepository {
    void save(Post post);

    List<Post> findAllPostsByAuthorIdentity(String authorIdentity);
}
