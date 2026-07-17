package com.joinin.notification.service.listener;

import com.join_in.kafka_models.KafkaMessage;
import com.join_in.kafka_models.messages.NewRegisteredUserInfo;
import com.joinin.notification.service.contract.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationListener {

    private final NotificationService notificationService;

    @KafkaListener(
            topics = "${spring.kafka.topic.new-registered-user-info}",
            groupId = "${spring.kafka.group-id}")
    public void newRegisteredUser(KafkaMessage message) {
        NewRegisteredUserInfo newRegisteredUserInfo = (NewRegisteredUserInfo) message;
        log.info("New registered user message received from Identity service. User identity: " + newRegisteredUserInfo.identity());
        notificationService.createCollection(newRegisteredUserInfo.identity());
    }
}
