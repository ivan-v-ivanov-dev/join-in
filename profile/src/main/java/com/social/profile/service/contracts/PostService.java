package com.social.profile.service.contracts;

import com.social.profile.model.EditPost;
import com.social.profile.model.Post;

import java.util.List;

public interface PostService {
    EditPost findByIdentity(String postIdentity, String authorIdentity);

    void post(String userIdentity, String content);

    void edit(String postIdentity, String authorIdentity, String newContent);

    void delete(String postIdentity, String authorIdentity);

    List<Post> findUserPosts(String identity);

    int findUserPostsCount(String identity);
}
