package com.social.reaction.service.contracts;

import com.social.reaction.model.Post;

public interface PostService {
    void save(Post post);

    void deleteNode(String postIdentity);

    void likePost(String userIdentity, String postIdentity);
}

