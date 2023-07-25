package com.social.notification.service;

import com.social.kafka.messages.NewPostCommentNotificationMessage;
import com.social.kafka.messages.NewUserMessage;
import com.social.kafka.messages.contract.KafkaMessage;
import com.social.notification.model.Notification;
import com.social.notification.service.contracts.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static com.social.notification.service.constants.LoggerConstants.NEW_POST_NOTIFICATION_MESSAGE_RECEIVED_FROM_POST_SERVICE_TEMPLATE;
import static com.social.notification.service.constants.LoggerConstants.NEW_USER_MESSAGE_RECEIVED_FROM_AUTHENTICATION_SERVICE_TEMPLATE;
import static com.social.notification.service.constants.ServiceConstants.NEW_POST_NOTIFICATION_TEMPLATE;

@Service
@Slf4j
public class NotificationListener {

    private final NotificationService notificationService;
    private final String newUserTopic;
    private final String newPostNotificationTopic;

    public NotificationListener(NotificationService notificationService,
                                @Value("${spring.kafka.topic.name.new.user}") String newUserTopic,
                                @Value("${spring.kafka.topic.name.new.post.notifications}") String newPostNotificationTopic) {
        this.notificationService = notificationService;
        this.newUserTopic = newUserTopic;
        this.newPostNotificationTopic = newPostNotificationTopic;
    }

    @KafkaListener(topics = "${spring.kafka.topic.name.new.user}", groupId = "${spring.kafka.group.id}")
    public void newUserListener(KafkaMessage kafkaMessage) {
        NewUserMessage newUserMessage = (NewUserMessage) kafkaMessage;
        log.info(String.format(NEW_USER_MESSAGE_RECEIVED_FROM_AUTHENTICATION_SERVICE_TEMPLATE,
                newUserTopic, newUserMessage.getIdentity()));

        notificationService.createCollection(newUserMessage.getIdentity());
    }

    @KafkaListener(topics = "${spring.kafka.topic.name.new.post.notifications}", groupId = "${spring.kafka.group.id}")
    public void newPostNotificationListener(KafkaMessage kafkaMessage) {
        NewPostCommentNotificationMessage newPostCommentNotificationMessage = (NewPostCommentNotificationMessage) kafkaMessage;
        log.info(String.format(NEW_POST_NOTIFICATION_MESSAGE_RECEIVED_FROM_POST_SERVICE_TEMPLATE, newPostNotificationTopic));

        Notification notification = Notification.builder()
                .authorIdentity(newPostCommentNotificationMessage.getAuthorIdentity())
                .postIdentity(newPostCommentNotificationMessage.getPostIdentity())
                .notification(String.format(NEW_POST_NOTIFICATION_TEMPLATE, newPostCommentNotificationMessage.getAuthorNames()))
                .date(LocalDate.parse(newPostCommentNotificationMessage.getDate()))
                .seen(false)
                .build();

        notificationService.save(notification, newPostCommentNotificationMessage.getPeopleToNotify());
    }

}
