package com.social.post.service.contracts;

import com.social.post.model.Post;

import java.util.List;

public interface PostService {
    void save(Post post);

    List<Post> findAllPostsByAuthorIdentity(String authorIdentity);
}
