package com.joinin.mvc.service;

import com.join_in.common_models.PostRpGatewayService;
import com.joinin.mvc.mappers.PostMapper;
import com.joinin.mvc.model.Post;
import com.joinin.mvc.service.contract.PostService;
import com.joinin.mvc.service.feign.GatewayClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final GatewayClient gatewayClient;
    private final PostMapper postMapper;

    @Override
    public List<Post> retrieveProfilePosts(String identity) {
        List<PostRpGatewayService> postRpGatewayServices = gatewayClient.retrieveProfilePosts(identity);
        log.info("Retrieve profile posts from API Gateway. Profile: " + identity);
        return postRpGatewayServices.stream()
                .map(postMapper::fromPostRpGatewayServicetoPost)
                .toList();
    }
}
