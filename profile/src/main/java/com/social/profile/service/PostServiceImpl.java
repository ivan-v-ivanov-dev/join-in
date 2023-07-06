package com.social.profile.service;

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

import static com.social.profile.service.constants.LoggerConstants.KAFKA_MESSAGE_FOR_NEW_POST_CREATED_AND_SEND_TO_POST_SERVICE_IN_TOPIC_TEMPLATE;

@Service
@Slf4j
public class PostServiceImpl implements PostService {

    private final KafkaTemplate<String, KafkaMessage> kafkaTemplate;
    @Value("${spring.kafka.topic.name.post.publication}")
    private String topicName;

    public PostServiceImpl(KafkaTemplate<String, KafkaMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void post(String userIdentity, String content) {
        KafkaMessage kafkaMessage = PostMessage.builder().userIdentity(userIdentity).content(content).build();

        Message<KafkaMessage> message = MessageBuilder
                .withPayload(kafkaMessage)
                .setHeader(KafkaHeaders.TOPIC, topicName)
                .build();

        kafkaTemplate.send(message);
        log.info(String.format(KAFKA_MESSAGE_FOR_NEW_POST_CREATED_AND_SEND_TO_POST_SERVICE_IN_TOPIC_TEMPLATE,
                userIdentity, topicName));
    }
}
