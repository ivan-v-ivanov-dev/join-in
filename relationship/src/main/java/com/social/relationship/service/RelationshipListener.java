package com.social.relationship.service;

import com.social.kafka.messages.RegisteredUserMessage;
import com.social.kafka.messages.contract.KafkaMessage;
import com.social.relationship.service.contract.ProfileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.social.relationship.service.constants.LoggerConstants.NEW_REGISTERED_USER_MESSAGE_RECEIVED_FROM_API_GATEWAY_SERVICE_TEMPLATE;

@Service
@AllArgsConstructor
@Slf4j
public class RelationshipListener {

    private final ProfileService profileService;
    @Value("${spring.kafka.topic.name.registered.user}")
    String registeredUserTopic;

    @KafkaListener(topics = "${spring.kafka.topic.name.registered.user}", groupId = "${spring.kafka.group.id}")
    public void listener(KafkaMessage kafkaMessage) {
        RegisteredUserMessage registeredUserMessage = (RegisteredUserMessage) kafkaMessage;
        log.info(String.format(NEW_REGISTERED_USER_MESSAGE_RECEIVED_FROM_API_GATEWAY_SERVICE_TEMPLATE,
                registeredUserTopic, registeredUserMessage.getIdentity()));

        profileService.createProfile(registeredUserMessage.getIdentity());
    }
}
