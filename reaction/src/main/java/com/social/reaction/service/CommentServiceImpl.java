package com.social.reaction.service;

import com.social.kafka.messages.NotificationMessage;
import com.social.kafka.messages.contract.KafkaMessage;
import com.social.reaction.model.Comment;
import com.social.reaction.repository.CommentRepository;
import com.social.reaction.service.contracts.CommentService;
import com.social.reaction.service.contracts.KafkaMessageSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;

import static com.social.reaction.service.constants.LoggerConstants.*;

@Service
@Slf4j
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final KafkaMessageSender kafkaMessageSender;
    private final String likeCommentNotificationTopic;

    public CommentServiceImpl(CommentRepository commentRepository,
                              KafkaMessageSender kafkaMessageSender,
                              @Value("${spring.kafka.topic.name.like.comment-notification}") String likeCommentNotificationTopic) {
        this.commentRepository = commentRepository;
        this.kafkaMessageSender = kafkaMessageSender;
        this.likeCommentNotificationTopic = likeCommentNotificationTopic;
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
        log.info(String.format(SAVE_COMMENT_IN_DATABASE_TEMPLATE, comment.getIdentity()));
    }

    @Override
    public void deleteNodes(Set<String> commentsNodesIdentities) {
        commentsNodesIdentities.forEach(commentRepository::deleteNodeWithRelations);
        log.info(COMMENT_NODES_DELETED);
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
