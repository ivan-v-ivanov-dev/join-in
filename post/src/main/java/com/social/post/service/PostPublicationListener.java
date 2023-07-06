package com.social.post.service;

import com.social.kafka.messages.PostMessage;
import com.social.kafka.messages.contract.KafkaMessage;
import com.social.post.model.Post;
import com.social.post.service.contracts.IdentityGeneratorService;
import com.social.post.service.contracts.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static com.social.post.service.constants.LoggerConstants.NEW_POST_PUBLISHED_MESSAGE_RECEIVED_FROM_PROFILE_SERVICE_TEMPLATE;

@Service
@Slf4j
public class PostPublicationListener {

    private final IdentityGeneratorService identityGeneratorService;
    private final PostService postService;
    @Value("${spring.kafka.topic.name.post.publication}")
    private String kafkaTopic;

    public PostPublicationListener(IdentityGeneratorService identityGeneratorService,
                                   PostService postService) {
        this.identityGeneratorService = identityGeneratorService;
        this.postService = postService;
    }

    @KafkaListener(topics = "${spring.kafka.topic.name.post.publication}", groupId = "${spring.kafka.group.id}")
    public void postPublicationListener(KafkaMessage kafkaMessage) {
        PostMessage postMessage = (PostMessage) kafkaMessage;
        log.info(String.format(NEW_POST_PUBLISHED_MESSAGE_RECEIVED_FROM_PROFILE_SERVICE_TEMPLATE,
                postMessage.getUserIdentity(), kafkaTopic));

        LocalDate dateNow = LocalDate.now();

        Post post = Post.builder()
                .authorIdentity(postMessage.getUserIdentity())
                .postIdentity(identityGeneratorService
                        .generate(postMessage.getUserIdentity(), postMessage.getContent(), dateNow.toString()))
                .content(postMessage.getContent())
                .postDate(dateNow)
                .build();

        postService.save(post);
    }
}
