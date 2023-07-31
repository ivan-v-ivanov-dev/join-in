package com.social.reaction.service;

import com.social.kafka.messages.NotificationMessage;
import com.social.kafka.messages.contract.KafkaMessage;
import com.social.reaction.model.Post;
import com.social.reaction.repository.CommentRepository;
import com.social.reaction.repository.PostRepository;
import com.social.reaction.repository.ProfileRepository;
import com.social.reaction.service.contracts.KafkaMessageSender;
import com.social.reaction.service.contracts.PostService;
import com.social.reaction.service.feign.PostClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static com.social.reaction.service.constants.LoggerConstants.*;

@Service
@Slf4j
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final ProfileRepository profileRepository;
    private final PostClient postClient;
    private final KafkaMessageSender kafkaMessageSender;
    private final String likePostNotificationTopic;
    private final String dislikePostNotificationTopic;
    private final String starPostNotificationTopic;
    private final String likeCommentNotificationTopic;

    public PostServiceImpl(PostRepository postRepository,
                           CommentRepository commentRepository,
                           ProfileRepository profileRepository,
                           PostClient postClient,
                           KafkaMessageSender kafkaMessageSender,
                           @Value("${spring.kafka.topic.name.like.post-notification}") String likePostNotificationTopic,
                           @Value("${spring.kafka.topic.name.dislike.post-notification}") String dislikePostNotificationTopic,
                           @Value("${spring.kafka.topic.name.star.post-notification}") String starPostNotificationTopic,
                           @Value("${spring.kafka.topic.name.like.comment-notification}") String likeCommentNotificationTopic) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.profileRepository = profileRepository;
        this.postClient = postClient;
        this.kafkaMessageSender = kafkaMessageSender;
        this.likePostNotificationTopic = likePostNotificationTopic;
        this.dislikePostNotificationTopic = dislikePostNotificationTopic;
        this.starPostNotificationTopic = starPostNotificationTopic;
        this.likeCommentNotificationTopic = likeCommentNotificationTopic;
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
        log.info(String.format(SAVE_POST_IN_DATABASE_TEMPLATE, post.getIdentity()));
    }

    @Override
    public void deleteNode(String postIdentity) {
        postRepository.deleteNodeWithRelations(postIdentity);
        log.info(POST_NODE_DELETED);
    }

    @Override
    public void likePost(String reactingUserIdentity, String postIdentity, String postAuthorIdentity, String postAuthorNames) {
        deletePreviousUserReactionsToThePost(reactingUserIdentity, postIdentity);
        Set<String> usersToNotify = collectUsersToNotify(postIdentity, postAuthorIdentity);

        postRepository.likePost(reactingUserIdentity, postIdentity);
        log.info(String.format(POST_LIKED_BY_USER_TEMPLATE, reactingUserIdentity, postIdentity));

        sendKafkaMessageNotificationsToTheRelatedUsers(usersToNotify, postAuthorIdentity,
                postAuthorNames, postIdentity, likePostNotificationTopic);
        log.info(String.format(LIKE_POST_NOTIFICATIONS_MESSAGE_SEND_TO_NOTIFICATION_SERVICE_TEMPLATE,
                likePostNotificationTopic));
    }

    @Override
    public void dislikePost(String reactingUserIdentity, String postIdentity, String postAuthorIdentity, String postAuthorNames) {
        deletePreviousUserReactionsToThePost(reactingUserIdentity, postIdentity);
        Set<String> usersToNotify = collectUsersToNotify(postIdentity, postAuthorIdentity);

        postRepository.dislikePost(reactingUserIdentity, postIdentity);
        log.info(String.format(POST_DISLIKED_BY_USER_TEMPLATE, reactingUserIdentity, postIdentity));

        sendKafkaMessageNotificationsToTheRelatedUsers(usersToNotify, postAuthorIdentity,
                postAuthorNames, postIdentity, dislikePostNotificationTopic);
        log.info(String.format(LIKE_POST_NOTIFICATIONS_MESSAGE_SEND_TO_NOTIFICATION_SERVICE_TEMPLATE,
                dislikePostNotificationTopic));
    }

    @Override
    public void starPost(String reactingUserIdentity, String postIdentity, String postAuthorIdentity, String postAuthorNames) {
        deletePreviousUserReactionsToThePost(reactingUserIdentity, postIdentity);
        Set<String> usersToNotify = collectUsersToNotify(postIdentity, postAuthorIdentity);

        postRepository.starPost(reactingUserIdentity, postIdentity);
        log.info(String.format(POST_STARED_BY_USER_TEMPLATE, reactingUserIdentity, postIdentity));

        sendKafkaMessageNotificationsToTheRelatedUsers(usersToNotify, postAuthorIdentity,
                postAuthorNames, postIdentity, starPostNotificationTopic);
        log.info(String.format(STAR_POST_NOTIFICATIONS_MESSAGE_SEND_TO_NOTIFICATION_SERVICE_TEMPLATE,
                starPostNotificationTopic));
    }

    @Override
    public void likeComment(String reactingUserIdentity, String commentIdentity, String postIdentity,
                            String commentAuthorIdentity, String commentAuthorNames) {
        deletePreviousUserReactionsToTheComment(reactingUserIdentity, commentIdentity);
        commentRepository.likeComment(reactingUserIdentity, commentIdentity);
        log.info(String.format(COMMENT_LIKED_BY_USER_TEMPLATE, reactingUserIdentity, commentIdentity));

        sendKafkaMessageNotificationsToTheRelatedUsers(Set.of(commentAuthorIdentity), commentAuthorIdentity,
                commentAuthorNames, postIdentity, likeCommentNotificationTopic);
        log.info(String.format(LIKE_COMMENT_NOTIFICATION_MESSAGE_SEND_TO_NOTIFICATION_SERVICE_TEMPLATE,
                likeCommentNotificationTopic));
    }

    private void deletePreviousUserReactionsToThePost(String reactingUserIdentity, String postIdentity) {
        postRepository.deletePossiblePreviousRelations(reactingUserIdentity, postIdentity);
        log.info(String.format(DELETE_PREVIOUS_POSSIBLE_REACTIONS_TO_THE_POST_TEMPLATE, reactingUserIdentity, postIdentity));
    }

    private Set<String> collectUsersToNotify(String postIdentity, String postAuthorIdentity) {
        Set<String> usersToNotify = new HashSet<>();
        usersToNotify.addAll(profileRepository.findPeopleWhoReactedToPost(postIdentity));
        usersToNotify.addAll(postClient.findAllUsersCommentingThePost(postIdentity, postAuthorIdentity));
        usersToNotify.add(postAuthorIdentity);
        return usersToNotify;
    }

    private void deletePreviousUserReactionsToTheComment(String reactingUserIdentity, String commentIdentity) {
        commentRepository.deletePossiblePreviousRelations(reactingUserIdentity, commentIdentity);
        log.info(String.format(DELETE_PREVIOUS_POSSIBLE_REACTIONS_TO_THE_COMMENT_TEMPLATE, reactingUserIdentity, commentIdentity));
    }

    private void sendKafkaMessageNotificationsToTheRelatedUsers(Set<String> usersToNotify, String postAuthorIdentity,
                                                                String postAuthorNames, String postIdentity, String topic) {
        KafkaMessage message = NotificationMessage.builder()
                .peopleToNotify(usersToNotify)
                .authorIdentity(postAuthorIdentity)
                .authorNames(postAuthorNames)
                .postIdentity(postIdentity)
                .date(LocalDate.now().toString())
                .build();
        kafkaMessageSender.send(message, topic);
    }
}
