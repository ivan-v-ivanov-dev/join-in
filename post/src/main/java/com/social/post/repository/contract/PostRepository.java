package com.social.post.repository.contract;

import com.social.post.model.Post;

import java.util.List;

public interface PostRepository {
    void save(Post post);

    Post findByPostIdentity(String postIdentity);

    List<Post> findAllPostsByAuthorIdentity(String authorIdentity);

    void delete(String postIdentity);

    void updateOne(String postIdentity, String newContent);

    int findAuthorPostsCount(String authorIdentity);

    void createNewUserCollection(String identity);
}
