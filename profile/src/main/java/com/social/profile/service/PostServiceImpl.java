package com.social.profile.service;

import com.social.kafka.messages.DeletePostMessage;
import com.social.kafka.messages.PostMessage;
import com.social.kafka.messages.contract.KafkaMessage;
import com.social.profile.service.contracts.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import static com.social.profile.service.constants.LoggerConstants.KAFKA_MESSAGE_FOR_DELETE_POST_CREATED_AND_SEND_TO_POST_SERVICE_IN_TOPIC_TEMPLATE;
import static com.social.profile.service.constants.LoggerConstants.KAFKA_MESSAGE_FOR_NEW_POST_CREATED_AND_SEND_TO_POST_SERVICE_IN_TOPIC_TEMPLATE;

@Service
@Slf4j
public class PostServiceImpl implements PostService {

    private final KafkaTemplate<String, KafkaMessage> kafkaTemplate;
    private final String postPublicationTopic;
    private final String deletePostTopic;

    public PostServiceImpl(KafkaTemplate<String, KafkaMessage> kafkaTemplate,
                           @Value("${spring.kafka.topic.name.post.publication}") String postPublicationTopic,
                           @Value("${spring.kafka.topic.name.delete.post}") String deletePostTopic) {
        this.kafkaTemplate = kafkaTemplate;
        this.postPublicationTopic = postPublicationTopic;
        this.deletePostTopic = deletePostTopic;
    }

    @Override
    public void post(String userIdentity, String content) {
        KafkaMessage kafkaMessage = PostMessage.builder().userIdentity(userIdentity).content(content).build();

        Message<KafkaMessage> message = MessageBuilder
                .withPayload(kafkaMessage)
                .setHeader(KafkaHeaders.TOPIC, postPublicationTopic)
                .build();

        kafkaTemplate.send(message);
        log.info(String.format(KAFKA_MESSAGE_FOR_NEW_POST_CREATED_AND_SEND_TO_POST_SERVICE_IN_TOPIC_TEMPLATE,
                userIdentity, postPublicationTopic));
    }

    @Override
    public void delete(String postIdentity) {
        KafkaMessage kafkaMessage = DeletePostMessage.builder().postIdentity(postIdentity).build();

        Message<KafkaMessage> message = MessageBuilder
                .withPayload(kafkaMessage)
                .setHeader(KafkaHeaders.TOPIC, deletePostTopic)
                .build();

        kafkaTemplate.send(message);
        log.info(String.format(KAFKA_MESSAGE_FOR_DELETE_POST_CREATED_AND_SEND_TO_POST_SERVICE_IN_TOPIC_TEMPLATE,
                postIdentity, deletePostTopic));
    }
}
