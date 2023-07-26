package com.social.post.repository.contract;

import com.social.post.model.Comment;
import com.social.post.model.Post;

import java.util.List;
import java.util.Set;

public interface PostRepository {
    void save(Post post, String collection);

    Post findByPostIdentity(String postIdentity, String collection);

    List<Post> findAllPostsByAuthorIdentity(String collection);

    void delete(String postIdentity, String collection);

    void updateOne(String postIdentity, String newContent, String collection);

    int findAuthorPostsCount(String collection);

    void createNewUserCollection(String collection);

    void saveComment(Comment comment, String postIdentity, String collection);

    Set<String> findAllCommentIdentitiesForAPost(String postIdentity, String collection);
}
