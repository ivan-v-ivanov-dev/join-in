package com.social.notification.service;

import com.social.kafka.messages.NewUserMessage;
import com.social.kafka.messages.NotificationMessage;
import com.social.kafka.messages.contract.KafkaMessage;
import com.social.notification.model.Notification;
import com.social.notification.service.contracts.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static com.social.notification.service.constants.LoggerConstants.*;
import static com.social.notification.service.constants.ServiceConstants.*;

@Service
@Slf4j
public class NotificationListener {

    private final NotificationService notificationService;
    private final String newUserTopic;
    private final String newPostNotificationTopic;
    private final String newCommentNotificationTopic;
    private final String likePostNotificationTopic;

    public NotificationListener(NotificationService notificationService,
                                @Value("${spring.kafka.topic.name.new.user}") String newUserTopic,
                                @Value("${spring.kafka.topic.name.new.post.notification}") String newPostNotificationTopic,
                                @Value("${spring.kafka.topic.name.new.comment.notification}") String newCommentNotificationTopic,
                                @Value("${spring.kafka.topic.name.like.post.notification}") String likePostNotificationTopic) {
        this.notificationService = notificationService;
        this.newUserTopic = newUserTopic;
        this.newPostNotificationTopic = newPostNotificationTopic;
        this.newCommentNotificationTopic = newCommentNotificationTopic;
        this.likePostNotificationTopic = likePostNotificationTopic;
    }

    @KafkaListener(topics = "${spring.kafka.topic.name.new.user}", groupId = "${spring.kafka.group.id}")
    public void newUserListener(KafkaMessage kafkaMessage) {
        NewUserMessage newUserMessage = (NewUserMessage) kafkaMessage;
        log.info(String.format(NEW_USER_MESSAGE_RECEIVED_FROM_AUTHENTICATION_SERVICE_TEMPLATE,
                newUserTopic, newUserMessage.getIdentity()));

        notificationService.createCollection(newUserMessage.getIdentity());
    }

    @KafkaListener(topics = "${spring.kafka.topic.name.new.post.notification}", groupId = "${spring.kafka.group.id}")
    public void newPostNotificationListener(KafkaMessage kafkaMessage) {
        NotificationMessage notificationMessage = (NotificationMessage) kafkaMessage;
        log.info(String.format(NEW_POST_NOTIFICATION_MESSAGE_RECEIVED_FROM_POST_SERVICE_TEMPLATE, newPostNotificationTopic));

        Notification notification = Notification.builder()
                .authorIdentity(notificationMessage.getAuthorIdentity())
                .postIdentity(notificationMessage.getPostIdentity())
                .notification(String.format(NEW_POST_NOTIFICATION_TEMPLATE, notificationMessage.getAuthorNames()))
                .date(LocalDate.parse(notificationMessage.getDate()))
                .seen(false)
                .build();

        notificationService.save(notification, notificationMessage.getPeopleToNotify());
    }

    @KafkaListener(topics = "${spring.kafka.topic.name.new.comment.notification}", groupId = "${spring.kafka.group.id}")
    public void newCommentNotificationListener(KafkaMessage kafkaMessage) {
        NotificationMessage notificationMessage = (NotificationMessage) kafkaMessage;
        log.info(String.format(NEW_COMMENT_NOTIFICATION_MESSAGE_RECEIVED_FROM_POST_SERVICE_TEMPLATE, newCommentNotificationTopic));

        Notification notification = Notification.builder()
                .authorIdentity(notificationMessage.getAuthorIdentity())
                .postIdentity(notificationMessage.getPostIdentity())
                .notification(String.format(NEW_COMMENT_NOTIFICATION_TEMPLATE, notificationMessage.getAuthorNames()))
                .date(LocalDate.parse(notificationMessage.getDate()))
                .seen(false)
                .build();

        notificationService.save(notification, notificationMessage.getPeopleToNotify());
    }

    @KafkaListener(topics = "${spring.kafka.topic.name.like.post.notification}", groupId = "${spring.kafka.group.id}")
    public void likePostNotificationListener(KafkaMessage kafkaMessage) {
        NotificationMessage notificationMessage = (NotificationMessage) kafkaMessage;
        log.info(String.format(LIKE_POST_NOTIFICATION_MESSAGE_RECEIVED_FROM_REACTION_SERVICE_TEMPLATE, likePostNotificationTopic));

        Notification notification = Notification.builder()
                .authorIdentity(notificationMessage.getAuthorIdentity())
                .postIdentity(notificationMessage.getPostIdentity())
                .notification(String.format(LIKED_POST_NOTIFICATION_TEMPLATE, notificationMessage.getAuthorNames()))
                .date(LocalDate.parse(notificationMessage.getDate()))
                .seen(false)
                .build();

        notificationService.save(notification, notificationMessage.getPeopleToNotify());
    }
}
