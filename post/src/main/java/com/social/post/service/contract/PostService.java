package com.social.post.service.contract;

import com.social.model.dto.PostRp;

import java.util.List;

public interface PostService {
    void createCollection(String identity);

    PostRp findByAuthorIdentityAndPostIdentity(String authorIdentity, String postIdentity);

    List<PostRp> findPostsByAuthorIdentity(String authorIdentity);

    int findAuthorPostsCount(String authorIdentity);
}
