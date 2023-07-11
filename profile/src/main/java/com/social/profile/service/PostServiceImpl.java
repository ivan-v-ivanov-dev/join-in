package com.social.profile.service;

import com.social.kafka.messages.DeletePostMessage;
import com.social.kafka.messages.PostMessage;
import com.social.kafka.messages.contract.KafkaMessage;
import com.social.profile.service.contracts.KafkaMessageSender;
import com.social.profile.service.contracts.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static com.social.profile.service.constants.LoggerConstants.DELETE_POST_CREATED_AND_SEND_TO_POST_SERVICE_TOPIC_NAME_POST_IDENTITY_TEMPLATE;
import static com.social.profile.service.constants.LoggerConstants.NEW_POST_CREATED_AND_SEND_TO_POST_SERVICE_TOPIC_NAME_USER_IDENTITY_TEMPLATE;

@Service
@Slf4j
public class PostServiceImpl implements PostService {

    private final KafkaMessageSender kafkaMessageSender;
    private final String postPublicationTopic;
    private final String deletePostTopic;

    public PostServiceImpl(KafkaMessageSender kafkaMessageSender,
                           @Value("${spring.kafka.topic.name.post.publication}") String postPublicationTopic,
                           @Value("${spring.kafka.topic.name.delete.post}") String deletePostTopic) {
        this.kafkaMessageSender = kafkaMessageSender;
        this.postPublicationTopic = postPublicationTopic;
        this.deletePostTopic = deletePostTopic;
    }

    @Override
    public void post(String userIdentity, String content) {
        KafkaMessage postPublicationMessage = PostMessage.builder().userIdentity(userIdentity).content(content).build();

        kafkaMessageSender.send(postPublicationMessage, postPublicationTopic);
        log.info(String.format(NEW_POST_CREATED_AND_SEND_TO_POST_SERVICE_TOPIC_NAME_USER_IDENTITY_TEMPLATE,
                userIdentity, postPublicationTopic));
    }

    @Override
    public void delete(String postIdentity) {
        KafkaMessage deletePostMessage = DeletePostMessage.builder().postIdentity(postIdentity).build();

        kafkaMessageSender.send(deletePostMessage, deletePostTopic);
        log.info(String.format(DELETE_POST_CREATED_AND_SEND_TO_POST_SERVICE_TOPIC_NAME_POST_IDENTITY_TEMPLATE,
                postIdentity, deletePostTopic));
    }
}
