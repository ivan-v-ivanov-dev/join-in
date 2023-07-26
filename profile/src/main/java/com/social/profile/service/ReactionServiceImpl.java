package com.social.profile.service;

import com.social.kafka.messages.ReactionMessage;
import com.social.kafka.messages.contract.KafkaMessage;
import com.social.profile.service.contracts.KafkaMessageSender;
import com.social.profile.service.contracts.ReactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static com.social.profile.service.constants.LoggerConstants.LIKE_POST_CREATED_AND_SEND_TO_REACTION_SERVICE_TOPIC_NAME_POST_IDENTITY_TEMPLATE;

@Service
@Slf4j
public class ReactionServiceImpl implements ReactionService {

    private final KafkaMessageSender kafkaMessageSender;
    private final String likePostTopic;

    public ReactionServiceImpl(KafkaMessageSender kafkaMessageSender,
                               @Value("${spring.kafka.topic.name.like.post}") String likePostTopic) {
        this.kafkaMessageSender = kafkaMessageSender;
        this.likePostTopic = likePostTopic;
    }

    @Override
    public void likePost(String userIdentity, String postIdentity) {
        KafkaMessage postReactionMessage = ReactionMessage.builder()
                .userIdentity(userIdentity)
                .postIdentity(postIdentity)
                .build();

        kafkaMessageSender.send(postReactionMessage, likePostTopic);
        log.info(String.format(LIKE_POST_CREATED_AND_SEND_TO_REACTION_SERVICE_TOPIC_NAME_POST_IDENTITY_TEMPLATE,
                likePostTopic, postIdentity));
    }
}
