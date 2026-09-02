package com.joinin.media.service.contract;

import com.joinin.media.model.Post;

public interface PostService {
    Post retrieveByIdentity(String identity);

    void savePostImage(String postIdentity, String imageIdentity, byte[] imageBytes);
}
