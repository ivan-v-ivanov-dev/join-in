package com.social.relationship.service;

import com.social.kafka.messages.FriendshipMessage;
import com.social.kafka.messages.NewUserMessage;
import com.social.kafka.messages.contract.KafkaMessage;
import com.social.relationship.model.Profile;
import com.social.relationship.service.contracts.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.social.relationship.service.constants.LoggerConstants.*;

@Service
@Slf4j
public class RelationListener {

    private final ProfileService profileService;
    private final String newUserTopic;
    private final String acceptFriendshipTopic;
    private final String declineFriendshipTopic;
    private final String unfriendTopic;

    public RelationListener(ProfileService profileService,
                            @Value("${spring.kafka.topic.name.new.user}") String newUserTopic,
                            @Value("${spring.kafka.topic.name.accept.friendship}") String acceptFriendshipTopic,
                            @Value("${spring.kafka.topic.name.decline.friendship}") String declineFriendshipTopic,
                            @Value("${spring.kafka.topic.name.unfriend}") String unfriendTopic) {
        this.profileService = profileService;
        this.newUserTopic = newUserTopic;
        this.acceptFriendshipTopic = acceptFriendshipTopic;
        this.declineFriendshipTopic = declineFriendshipTopic;
        this.unfriendTopic = unfriendTopic;
    }

    @KafkaListener(topics = "${spring.kafka.topic.name.new.user}", groupId = "${spring.kafka.group.id}")
    public void listener(KafkaMessage kafkaMessage) {
        NewUserMessage newUserMessage = (NewUserMessage) kafkaMessage;
        log.info(String.format(NEW_USER_MESSAGE_RECEIVED_FROM_AUTHENTICATION_SERVICE_TEMPLATE,
                newUserTopic, newUserMessage.getIdentity()));

        Profile profile = Profile.builder().identity(newUserMessage.getIdentity()).build();

        profileService.save(profile);
    }

    @KafkaListener(topics = "${spring.kafka.topic.name.accept.friendship}", groupId = "${spring.kafka.group.id}")
    public void acceptFriendshipListener(KafkaMessage kafkaMessage) {
        FriendshipMessage acceptFriendshipMessage = (FriendshipMessage) kafkaMessage;
        log.info(String.format(ACCEPT_FRIENDSHIP_MESSAGE_RECEIVED_FROM_PROFILE_SERVICE_TEMPLATE,
                acceptFriendshipTopic, acceptFriendshipMessage.getRecipientUserIdentity()));

        profileService.acceptFriendship(acceptFriendshipMessage.getSenderUserIdentity(),
                acceptFriendshipMessage.getRecipientUserIdentity());
    }

    @KafkaListener(topics = "${spring.kafka.topic.name.decline.friendship}", groupId = "${spring.kafka.group.id}")
    public void declineFriendshipListener(KafkaMessage kafkaMessage) {
        FriendshipMessage declineFriendshipMessage = (FriendshipMessage) kafkaMessage;
        log.info(String.format(DECLINE_FRIENDSHIP_MESSAGE_RECEIVED_FROM_PROFILE_SERVICE_TEMPLATE,
                declineFriendshipTopic, declineFriendshipMessage.getRecipientUserIdentity()));

        profileService.declineFriendship(declineFriendshipMessage.getSenderUserIdentity(),
                declineFriendshipMessage.getRecipientUserIdentity());
    }

    @KafkaListener(topics = "${spring.kafka.topic.name.unfriend}", groupId = "${spring.kafka.group.id}")
    public void unfriendListener(KafkaMessage kafkaMessage) {
        FriendshipMessage unfriendMessage = (FriendshipMessage) kafkaMessage;
        log.info(String.format(UNFRIEND_USER_MESSAGE_RECEIVED_FROM_PROFILE_SERVICE_TEMPLATE,
                unfriendTopic, unfriendMessage.getRecipientUserIdentity()));

        profileService.unfriend(unfriendMessage.getSenderUserIdentity(), unfriendMessage.getRecipientUserIdentity());
    }
}
