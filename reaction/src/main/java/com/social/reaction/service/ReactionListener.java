package com.social.reaction.service;

import com.social.kafka.messages.NewUserMessage;
import com.social.kafka.messages.contract.KafkaMessage;
import com.social.reaction.model.Profile;
import com.social.reaction.service.contracts.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.social.reaction.service.constants.LoggerConstants.NEW_USER_MESSAGE_RECEIVED_FROM_AUTHENTICATION_SERVICE_TEMPLATE;

@Service
@Slf4j
public class ReactionListener {

    private final ProfileService profileService;
    private final String newUserTopic;

    public ReactionListener(ProfileService profileService,
                            @Value("${spring.kafka.topic.name.new.user}") String newUserTopic) {
        this.profileService = profileService;
        this.newUserTopic = newUserTopic;
    }

    @KafkaListener(topics = "${spring.kafka.topic.name.new.user}", groupId = "${spring.kafka.group.id}")
    public void listener(KafkaMessage kafkaMessage) {
        NewUserMessage newUserMessage = (NewUserMessage) kafkaMessage;
        log.info(String.format(NEW_USER_MESSAGE_RECEIVED_FROM_AUTHENTICATION_SERVICE_TEMPLATE,
                newUserTopic, newUserMessage.getIdentity()));

        Profile profile = Profile.builder().identity(newUserMessage.getIdentity()).build();

        profileService.save(profile);
    }
}
