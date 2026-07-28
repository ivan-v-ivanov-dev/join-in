package com.joinin.post.service.contract;

import com.joinin.post.model.PostResponse;

import java.util.List;

public interface PostService {
    PostResponse retrievePostByIdentity(String postIdentity);

    List<PostResponse> retrievePostsByAuthor(String identity);
}
