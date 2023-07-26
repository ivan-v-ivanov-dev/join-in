package com.social.profile.service;

import com.social.kafka.messages.ReactionMessage;
import com.social.kafka.messages.contract.KafkaMessage;
import com.social.profile.repository.contract.ProfileRepository;
import com.social.profile.service.contracts.KafkaMessageSender;
import com.social.profile.service.contracts.ReactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static com.social.profile.service.constants.LoggerConstants.*;
import static com.social.profile.service.constants.ServiceConstants.AUTHOR_NAME_TEMPLATE;

@Service
@Slf4j
public class ReactionServiceImpl implements ReactionService {

    private final ProfileRepository profileRepository;
    private final KafkaMessageSender kafkaMessageSender;
    private final String likePostTopic;
    private final String dislikePostTopic;
    private final String starPostTopic;

    public ReactionServiceImpl(ProfileRepository profileRepository,
                               KafkaMessageSender kafkaMessageSender,
                               @Value("${spring.kafka.topic.name.like.post}") String likePostTopic,
                               @Value("${spring.kafka.topic.name.dislike.post}") String dislikePostTopic,
                               @Value("${spring.kafka.topic.name.star.post}") String starPostTopic) {
        this.profileRepository = profileRepository;
        this.kafkaMessageSender = kafkaMessageSender;
        this.likePostTopic = likePostTopic;
        this.dislikePostTopic = dislikePostTopic;
        this.starPostTopic = starPostTopic;
    }

    @Override
    public void likePost(String reactingUserIdentity, String postIdentity, String postAuthorIdentity) {
        KafkaMessage postReactionMessage = createKafkaMessage(reactingUserIdentity, postIdentity, postAuthorIdentity);
        kafkaMessageSender.send(postReactionMessage, likePostTopic);
        log.info(String.format(LIKE_POST_MESSAGE_CREATED_AND_SEND_TO_REACTION_SERVICE_TOPIC_NAME_POST_IDENTITY_TEMPLATE,
                likePostTopic, postIdentity));
    }

    @Override
    public void dislikePost(String reactingUserIdentity, String postIdentity, String postAuthorIdentity) {
        KafkaMessage postReactionMessage = createKafkaMessage(reactingUserIdentity, postIdentity, postAuthorIdentity);
        kafkaMessageSender.send(postReactionMessage, dislikePostTopic);
        log.info(String.format(DISLIKE_POST_MESSAGE_CREATED_AND_SEND_TO_REACTION_SERVICE_TOPIC_NAME_POST_IDENTITY_TEMPLATE,
                dislikePostTopic, postIdentity));
    }

    @Override
    public void starPost(String reactingUserIdentity, String postIdentity, String postAuthorIdentity) {
        KafkaMessage starPostMessage = createKafkaMessage(reactingUserIdentity, postIdentity, postAuthorIdentity);
        kafkaMessageSender.send(starPostMessage, starPostTopic);
        log.info(String.format(STAR_POST_MESSAGE_CREATED_AND_SEND_TO_REACTION_SERVICE_TOPIC_NAME_POST_IDENTITY_TEMPLATE,
                starPostTopic, postIdentity));
    }

    private KafkaMessage createKafkaMessage(String reactingUserIdentity, String postIdentity, String postAuthorIdentity) {
        return ReactionMessage.builder()
                .reactingUserIdentity(reactingUserIdentity)
                .postIdentity(postIdentity)
                .postAuthorIdentity(postAuthorIdentity)
                .postAuthorNames(String.format(AUTHOR_NAME_TEMPLATE,
                        profileRepository.findProfileFirstName(postAuthorIdentity),
                        profileRepository.findProfileLastName(postAuthorIdentity)))
                .build();
    }
}
