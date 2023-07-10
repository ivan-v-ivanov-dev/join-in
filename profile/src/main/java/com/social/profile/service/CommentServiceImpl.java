package com.social.profile.service;

import com.social.kafka.messages.CommentMessage;
import com.social.kafka.messages.contract.KafkaMessage;
import com.social.profile.service.contracts.CommentService;
import com.social.profile.service.contracts.KafkaMessageSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static com.social.profile.service.constants.LoggerConstants.KAFKA_MESSAGE_FOR_NEW_COMMENT_CREATED_AND_SEND_TO_POST_SERVICE_IN_TOPIC_TEMPLATE;

@Service
@Slf4j
public class CommentServiceImpl implements CommentService {

    private final KafkaMessageSender kafkaMessageSender;
    @Value("${spring.kafka.topic.name.post.comment}")
    private String topicName;

    public CommentServiceImpl(KafkaMessageSender kafkaMessageSender) {
        this.kafkaMessageSender = kafkaMessageSender;
    }

    @Override
    public void comment(String userIdentity, String comment) {
        KafkaMessage kafkaMessage = CommentMessage.builder().userIdentity(userIdentity).content(comment).build();

        kafkaMessageSender.send(kafkaMessage, topicName);
        log.info(String.format(KAFKA_MESSAGE_FOR_NEW_COMMENT_CREATED_AND_SEND_TO_POST_SERVICE_IN_TOPIC_TEMPLATE, userIdentity, topicName));
    }
}