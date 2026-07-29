package com.joinin.mvc.service.contract;

import com.joinin.mvc.model.Post;

import java.util.List;

public interface PostService {
    List<Post> retrieveProfilePosts(String identity);
}
