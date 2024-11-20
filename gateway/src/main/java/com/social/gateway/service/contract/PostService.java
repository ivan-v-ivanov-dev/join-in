package com.social.gateway.service.contract;

import com.social.model.dto.PostGatewayRp;

import java.util.List;

public interface PostService {
    PostGatewayRp findByAuthorIdentityAndPostIdentity(String authorIdentity, String postIdentity);

    List<PostGatewayRp> findPostsByAuthorIdentity(String identity);

    void post(String identity, String content);
}
