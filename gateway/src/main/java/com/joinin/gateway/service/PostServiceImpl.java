package com.joinin.gateway.service;

import com.join_in.common_models.PostRpGatewayService;
import com.join_in.common_models.PostRpPostService;
import com.joinin.gateway.mapper.PostMapper;
import com.joinin.gateway.service.contract.PostService;
import com.joinin.gateway.service.feign.PostServiceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostServiceClient postServiceClient;
    private final PostMapper postMapper;

    @Override
    public List<PostRpGatewayService> retrieveProfilePosts(String identity) {
        List<PostRpPostService> postRpPostServices = postServiceClient.retrievePostsByAuthor(identity);
        log.info("Retrieve profile posts: " + identity);
        return postRpPostServices.stream()
                .map(postMapper::fromPostRpPostServicetoPostRpGatewayService)
                .toList();
    }
}
