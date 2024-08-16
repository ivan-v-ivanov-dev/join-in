package com.social.authentication.service;

import com.social.authentication.service.contract.RegisterService;
import com.social.kafka.messages.RegisteredUserMessage;
import com.social.kafka.messages.contract.KafkaMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.social.authentication.service.constants.LoggerConstants.NEW_REGISTERED_USER_MESSAGE_RECEIVED_FROM_PROFILE_SERVICE_TEMPLATE;

@Service
@AllArgsConstructor
@Slf4j
public class RegisteredUserListener {

    private final RegisterService registerService;
    @Value("${spring.kafka.topic.name.registered.user}")
    String registeredUserTopic;

    @KafkaListener(topics = "${spring.kafka.topic.name.registered.user}", groupId = "${spring.kafka.group.id}")
    public void listener(KafkaMessage kafkaMessage) {
        RegisteredUserMessage registeredUserMessage = (RegisteredUserMessage) kafkaMessage;
        log.info(String.format(NEW_REGISTERED_USER_MESSAGE_RECEIVED_FROM_PROFILE_SERVICE_TEMPLATE,
                registeredUserTopic, registeredUserMessage.getIdentity()));

        registerService.register(registeredUserMessage.getIdentity(),
                registeredUserMessage.getEmail(), registeredUserMessage.getPassword());
    }
}
