package com.social.post.service;

import com.social.kafka.messages.DeletePostMessage;
import com.social.kafka.messages.contract.KafkaMessage;
import com.social.post.service.contracts.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.social.post.service.constants.LoggerConstants.NEW_DELETE_POST_MESSAGE_RECEIVED_FROM_PROFILE_SERVICE_TEMPLATE;

@Service
@Slf4j
public class DeletePostListener {

    private final PostService postService;
    private final String kafkaTopic;

    public DeletePostListener(PostService postService,
                              @Value("${spring.kafka.topic.name.delete.post}") String kafkaTopic) {
        this.postService = postService;
        this.kafkaTopic = kafkaTopic;
    }

    @KafkaListener(topics = "${spring.kafka.topic.name.delete.post}", groupId = "${spring.kafka.group.id}")
    public void postCommentListener(KafkaMessage kafkaMessage) {
        DeletePostMessage deletePostMessage = (DeletePostMessage) kafkaMessage;
        log.info(String.format(NEW_DELETE_POST_MESSAGE_RECEIVED_FROM_PROFILE_SERVICE_TEMPLATE,
                deletePostMessage.getPostIdentity(), kafkaTopic));

        postService.delete(deletePostMessage.getPostIdentity());
    }
}
