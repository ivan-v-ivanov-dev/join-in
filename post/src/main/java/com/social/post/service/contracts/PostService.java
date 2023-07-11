package com.social.post.service.contracts;

import com.social.post.model.Post;

import java.util.List;

public interface PostService {
    void save(Post post);

    Post findByPostIdentity(String postIdentity);

    List<Post> findAllPostsByAuthorIdentity(String authorIdentity);

    void delete(String postIdentity);

    void edit(String postIdentity, String newContent);

    int findAuthorPostsCount(String authorIdentity);
}
