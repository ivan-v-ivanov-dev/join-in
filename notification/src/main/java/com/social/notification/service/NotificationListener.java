package com.social.notification.service;

import com.social.kafka.messages.NewUserMessage;
import com.social.kafka.messages.contract.KafkaMessage;
import com.social.notification.service.contracts.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.social.notification.service.constants.LoggerConstants.NEW_USER_MESSAGE_RECEIVED_FROM_AUTHENTICATION_SERVICE_TEMPLATE;

@Service
@Slf4j
public class NotificationListener {

    private final NotificationService notificationService;
    private final String newUserTopic;

    public NotificationListener(NotificationService notificationService,
                                @Value("${spring.kafka.topic.name.new.user}") String newUserTopic) {
        this.notificationService = notificationService;
        this.newUserTopic = newUserTopic;
    }

    @KafkaListener(topics = "${spring.kafka.topic.name.new.user}", groupId = "${spring.kafka.group.id}")
    public void listener(KafkaMessage kafkaMessage) {
        NewUserMessage newUserMessage = (NewUserMessage) kafkaMessage;
        log.info(String.format(NEW_USER_MESSAGE_RECEIVED_FROM_AUTHENTICATION_SERVICE_TEMPLATE,
                newUserTopic, newUserMessage.getIdentity()));

        notificationService.createCollection(newUserMessage.getIdentity());
    }
}
