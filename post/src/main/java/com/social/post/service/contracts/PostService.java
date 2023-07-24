package com.social.post.service.contracts;

import com.social.post.model.Post;

import java.util.List;

public interface PostService {
    void save(Post post, String authorIdentity, String authorNames);

    Post findByPostIdentity(String postIdentity, String authorIdentity);

    List<Post> findAllPostsByAuthorIdentity(String authorIdentity);

    void delete(String postIdentity, String authorIdentity);

    void edit(String postIdentity, String newContent, String authorIdentity);

    int findAuthorPostsCount(String authorIdentity);

    void createNewUserCollection(String identity);
}
