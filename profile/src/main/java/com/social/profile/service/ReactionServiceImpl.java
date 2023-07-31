package com.social.profile.service;

import com.social.kafka.messages.CommentReactionMessage;
import com.social.kafka.messages.PostReactionMessage;
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
    private final String likeCommentTopic;
    private final String dislikeCommentTopic;

    public ReactionServiceImpl(ProfileRepository profileRepository,
                               KafkaMessageSender kafkaMessageSender,
                               @Value("${spring.kafka.topic.name.like.post}") String likePostTopic,
                               @Value("${spring.kafka.topic.name.dislike.post}") String dislikePostTopic,
                               @Value("${spring.kafka.topic.name.star.post}") String starPostTopic,
                               @Value("${spring.kafka.topic.name.like.comment}") String likeCommentTopic,
                               @Value("${spring.kafka.topic.name.dislike.comment}") String dislikeCommentTopic) {
        this.profileRepository = profileRepository;
        this.kafkaMessageSender = kafkaMessageSender;
        this.likePostTopic = likePostTopic;
        this.dislikePostTopic = dislikePostTopic;
        this.starPostTopic = starPostTopic;
        this.likeCommentTopic = likeCommentTopic;
        this.dislikeCommentTopic = dislikeCommentTopic;
    }

    @Override
    public void likePost(String reactingUserIdentity, String postIdentity, String postAuthorIdentity) {
        KafkaMessage postReactionMessage = createPostReactionKafkaMessage(reactingUserIdentity, postIdentity, postAuthorIdentity);
        kafkaMessageSender.send(postReactionMessage, likePostTopic);
        log.info(String.format(LIKE_POST_MESSAGE_CREATED_AND_SEND_TO_REACTION_SERVICE_TOPIC_NAME_POST_IDENTITY_TEMPLATE,
                likePostTopic, postIdentity));
    }

    @Override
    public void dislikePost(String reactingUserIdentity, String postIdentity, String postAuthorIdentity) {
        KafkaMessage postReactionMessage = createPostReactionKafkaMessage(reactingUserIdentity, postIdentity, postAuthorIdentity);
        kafkaMessageSender.send(postReactionMessage, dislikePostTopic);
        log.info(String.format(DISLIKE_POST_MESSAGE_CREATED_AND_SEND_TO_REACTION_SERVICE_TOPIC_NAME_POST_IDENTITY_TEMPLATE,
                dislikePostTopic, postIdentity));
    }

    @Override
    public void starPost(String reactingUserIdentity, String postIdentity, String postAuthorIdentity) {
        KafkaMessage starPostMessage = createPostReactionKafkaMessage(reactingUserIdentity, postIdentity, postAuthorIdentity);
        kafkaMessageSender.send(starPostMessage, starPostTopic);
        log.info(String.format(STAR_POST_MESSAGE_CREATED_AND_SEND_TO_REACTION_SERVICE_TOPIC_NAME_POST_IDENTITY_TEMPLATE,
                starPostTopic, postIdentity));
    }

    @Override
    public void likeComment(String reactingUserIdentity, String commentIdentity, String postIdentity, String commentAuthorIdentity) {
        KafkaMessage likeCommentMessage = createCommentReactionKafkaMessage(reactingUserIdentity, commentIdentity, postIdentity, commentAuthorIdentity);
        kafkaMessageSender.send(likeCommentMessage, likeCommentTopic);
        log.info(String.format(LIKE_COMMENT_MESSAGE_CREATED_AND_SEND_TO_REACTION_SERVICE_TOPIC_NAME_COMMENT_IDENTITY_TEMPLATE,
                likeCommentTopic, commentIdentity));
    }

    @Override
    public void dislikeComment(String reactingUserIdentity, String commentIdentity, String postIdentity, String commentAuthorIdentity) {
        KafkaMessage dislikeCommentMessage = createCommentReactionKafkaMessage(reactingUserIdentity, commentIdentity, postIdentity, commentAuthorIdentity);
        kafkaMessageSender.send(dislikeCommentMessage, dislikeCommentTopic);
        log.info(String.format(DISLIKE_COMMENT_MESSAGE_CREATED_AND_SEND_TO_REACTION_SERVICE_TOPIC_NAME_COMMENT_IDENTITY_TEMPLATE,
                dislikeCommentTopic, commentIdentity));
    }

    private KafkaMessage createPostReactionKafkaMessage(String reactingUserIdentity, String postIdentity, String postAuthorIdentity) {
        return PostReactionMessage.builder()
                .reactingUserIdentity(reactingUserIdentity)
                .postIdentity(postIdentity)
                .postAuthorIdentity(postAuthorIdentity)
                .postAuthorNames(String.format(AUTHOR_NAME_TEMPLATE,
                        profileRepository.findProfileFirstName(postAuthorIdentity),
                        profileRepository.findProfileLastName(postAuthorIdentity)))
                .build();
    }

    private KafkaMessage createCommentReactionKafkaMessage(String reactingUserIdentity, String commentIdentity,
                                                           String postIdentity, String commentAuthorIdentity) {
        return CommentReactionMessage.builder()
                .reactingUserIdentity(reactingUserIdentity)
                .commentIdentity(commentIdentity)
                .postIdentity(postIdentity)
                .commentAuthorIdentity(commentAuthorIdentity)
                .commentAuthorNames(String.format(AUTHOR_NAME_TEMPLATE,
                        profileRepository.findProfileFirstName(commentAuthorIdentity),
                        profileRepository.findProfileLastName(commentAuthorIdentity)))
                .build();
    }
}
