package com.social.profile.service;

import com.social.kafka.messages.RegisteredUserMessage;
import com.social.kafka.messages.contract.KafkaMessage;
import com.social.profile.model.Profile;
import com.social.profile.service.contracts.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.social.profile.service.constants.LoggerConstants.KAFKA_MESSAGE_FROM_AUTHENTICATION_SERVICE_IN_TOPIC_FOR_NEW_REGISTERED_USER_RECEIVED_TEMPLATE;
import static com.social.profile.service.constants.LoggerConstants.SAVE_THE_USER_IN_DATABASE_TEMPLATE;

@Service
@Slf4j
public class RegisteredUserListener {

    private final ProfileService profileService;
    @Value("${spring.kafka.topic.name}")
    private String topicName;

    public RegisteredUserListener(ProfileService profileService) {
        this.profileService = profileService;
    }

    @KafkaListener(topics = "#{'${spring.kafka.topic.name}'}", groupId = "#{'${spring.kafka.group.id}'}")
    public void shopListener(KafkaMessage kafkaMessage) {
        RegisteredUserMessage registeredUserMessage = (RegisteredUserMessage) kafkaMessage;
        log.info(String.format(KAFKA_MESSAGE_FROM_AUTHENTICATION_SERVICE_IN_TOPIC_FOR_NEW_REGISTERED_USER_RECEIVED_TEMPLATE,
                topicName, registeredUserMessage.getIdentity()));

        Profile profile = Profile.builder()
                .identity(registeredUserMessage.getIdentity())
                .firstName(registeredUserMessage.getFirstName())
                .lastName(registeredUserMessage.getLastName())
                .email(registeredUserMessage.getEmail())
                .joined(registeredUserMessage.getJoined())
                .build();

        log.info(String.format(SAVE_THE_USER_IN_DATABASE_TEMPLATE, profile.getIdentity()));
        profileService.save(profile);
    }
}
