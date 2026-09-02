package com.joinin.gateway.service.contract;

import com.join_in.common_models.PostGatewayRq;
import com.join_in.common_models.PostRpGatewayService;

import java.util.List;

public interface PostService {
    List<PostRpGatewayService> retrieveProfilePosts(String identity);

    int retrieveProfilePostsCount(String identity);

    int retrieveProfileCommentsCount(String identity);

    List<PostRpGatewayService> retrieveProfileFeedPosts(String identity);

    void postAPost(String identity, PostGatewayRq postGatewayRq);
}
