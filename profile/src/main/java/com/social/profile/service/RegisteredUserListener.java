package com.social.profile.service;

import com.social.kafka.messages.RegisteredUserMessage;
import com.social.kafka.messages.contract.KafkaMessage;
import com.social.profile.model.Profile;
import com.social.profile.service.contrancts.ProfileService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class RegisteredUserListener {

    private final ProfileService profileService;

    public RegisteredUserListener(ProfileService profileService) {
        this.profileService = profileService;
    }

    @KafkaListener(topics = "registered-user-profile-topic", groupId = "group_id")
    public void shopListener(KafkaMessage kafkaMessage) {
        RegisteredUserMessage registeredUserMessage = (RegisteredUserMessage) kafkaMessage;

        Profile profile = Profile.builder()
                .identity(registeredUserMessage.getIdentity())
                .firstName(registeredUserMessage.getFirstName())
                .lastName(registeredUserMessage.getLastName())
                .email(registeredUserMessage.getEmail())
                .joined(registeredUserMessage.getJoined())
                .build();

        profileService.save(profile);
    }
}
