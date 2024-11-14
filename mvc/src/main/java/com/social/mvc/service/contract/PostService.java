package com.social.mvc.service.contract;

import com.social.model.dto.PostGatewayRp;

import java.util.List;

public interface PostService {
    List<PostGatewayRp> findPostsByAuthorIdentity(String identity);
}
