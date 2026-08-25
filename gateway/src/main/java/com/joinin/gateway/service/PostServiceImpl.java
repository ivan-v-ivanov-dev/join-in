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
        List<PostRpPostService> posts = postServiceClient.retrievePostsByAuthor(identity);
        log.info("Retrieve profile posts: " + identity);
        return posts.stream()
                .map(postMapper::fromPostRpPostServicetoPostRpGatewayService)
                .toList();
    }

    @Override
    public List<PostRpGatewayService> retrieveProfileFeedPosts(String identity) {
        List<PostRpPostService> posts = postServiceClient.retrieveProfileFeedPosts(identity);
        log.info("Retrieve profile feed posts: " + identity);
        return posts.stream()
                .map(postMapper::fromPostRpPostServicetoPostRpGatewayService)
                .toList();
    }

    @Override
    public int retrieveProfilePostsCount(String identity) {
        int postsCount = postServiceClient.retrieveAuthorPostsCount(identity);
        log.info("Retrieve posts count for Profile: " + identity);
        return postsCount;
    }

    @Override
    public int retrieveProfileCommentsCount(String identity) {
        int commentsCount = postServiceClient.retrieveAuthorCommentsCount(identity);
        log.info("Retrieve comments count for Profile: " + identity);
        return commentsCount;
    }
}
