package com.joinin.gateway.service;

import com.join_in.common_models.PostGatewayRq;
import com.join_in.common_models.PostRpGatewayService;
import com.join_in.common_models.PostRpPostService;
import com.join_in.kafka_models.KafkaMessage;
import com.join_in.kafka_models.messages.Post;
import com.joinin.gateway.mapper.PostMapper;
import com.joinin.gateway.service.contract.PostService;
import com.joinin.gateway.service.feign.PostServiceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostServiceClient postServiceClient;
    private final PostMapper postMapper;
    private final KafkaTemplate<String, KafkaMessage> kafkaTemplate;

    @Value("${spring.kafka.topic.post-a-post}")
    private String postAPostTopic;

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

    @Override
    public void postAPost(String identity, PostGatewayRq postGatewayRq) {
        KafkaMessage postMessage = new Post(identity, postGatewayRq.groupIdentity(), postGatewayRq.content(),
                postGatewayRq.imageBytes(), postGatewayRq.youtubeUrl(),
                postGatewayRq.pollQuestion(), postGatewayRq.pollOptions());
        kafkaTemplate.send(postAPostTopic, postMessage);
        log.info("Post a new post message sent to Post service. Profile identity: " + identity);
    }
}
