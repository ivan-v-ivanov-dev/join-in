package com.joinin.post.service.listener;

import com.join_in.kafka_models.KafkaMessage;
import com.join_in.kafka_models.messages.Post;
import com.joinin.post.service.contract.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostServiceListener {

    private final PostService postService;

    @KafkaListener(
            topics = "${spring.kafka.topic.post-a-post}",
            groupId = "${spring.kafka.group-id}")
    public void postAPost(KafkaMessage message) {
        Post newPost = (Post) message;
        log.info("New post message received from Gateway service. Profile identity: " + newPost.profileIdentity());
        postService.postAPost(newPost.profileIdentity(), newPost.groupIdentity(), newPost.content(),
                newPost.imageBytes(), newPost.youtubeUrl(),
                newPost.pollQuestion(), newPost.pollOptions());
    }
}
