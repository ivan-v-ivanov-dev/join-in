package com.social.relationship.service;

import com.social.kafka.messages.RegisteredUserMessage;
import com.social.kafka.messages.contract.KafkaMessage;
import com.social.relationship.service.contract.ProfileService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static com.social.relationship.service.constants.LoggerConstants.NEW_REGISTERED_USER_MESSAGE_RECEIVED_FROM_API_GATEWAY_SERVICE_TEMPLATE;
import static java.lang.String.format;

@Component
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Slf4j
public class RelationshipListener {

    private final ProfileService profileService;
    @Value("${spring.kafka.topic.name.registered.user}")
    private String registeredUserTopic;

    @KafkaListener(topics = "${spring.kafka.topic.name.registered.user}", groupId = "${spring.kafka.group.id}")
    public void listener(KafkaMessage kafkaMessage) {
        RegisteredUserMessage registeredUserMessage = (RegisteredUserMessage) kafkaMessage;
        log.info(format(NEW_REGISTERED_USER_MESSAGE_RECEIVED_FROM_API_GATEWAY_SERVICE_TEMPLATE,
                registeredUserTopic, registeredUserMessage.getIdentity()));

        profileService.createProfile(registeredUserMessage.getIdentity());
    }
}
