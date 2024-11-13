package com.social.gateway.service.contract;

import com.social.model.dto.PostGatewayRp;

public interface PostService {
    PostGatewayRp findByAuthorIdentityAndPostIdentity(String authorIdentity, String postIdentity);
}
