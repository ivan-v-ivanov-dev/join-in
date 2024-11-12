package com.social.post.service.contract;

import com.social.model.dto.PostRp;

public interface PostService {
    void createCollection(String identity);

    PostRp findByAuthorIdentityAndPostIdentity(String authorIdentity, String postIdentity);
}
