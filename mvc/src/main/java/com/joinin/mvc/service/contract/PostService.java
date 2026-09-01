package com.joinin.mvc.service.contract;

import com.joinin.mvc.model.Post;
import com.joinin.mvc.model.PostRq;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface PostService {
    List<Post> retrieveProfilePosts(String identity);

    int retrievePostsCount(String identity);

    int retrieveCommentsCount(String identity);

    List<Post> retrieveProfileFeedPosts(String identity);

    void post(String identity, PostRq postRq);
}
