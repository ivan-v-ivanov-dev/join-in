package com.joinin.relationship.service.listener;

import com.join_in.kafka_models.KafkaMessage;
import com.join_in.kafka_models.messages.NewRegisteredUserInfo;
import com.join_in.kafka_models.messages.Unfriend;
import com.joinin.relationship.service.contract.ProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RelationshipListener {

    private final ProfileService profileService;

    @KafkaListener(
            topics = "${spring.kafka.topic.new-registered-user-info}",
            groupId = "${spring.kafka.group-id}")
    public void newRegisteredUser(KafkaMessage message) {
        NewRegisteredUserInfo newRegisteredUserInfo = (NewRegisteredUserInfo) message;
        log.info("New registered user message received from Identity service. Profile identity: " + newRegisteredUserInfo.identity());
        profileService.createProfile(newRegisteredUserInfo.identity());
    }

    @KafkaListener(
            topics = "${spring.kafka.topic.unfriend}",
            groupId = "${spring.kafka.group-id}")
    public void unfriend(KafkaMessage message) {
        Unfriend unfriendMessage = (Unfriend) message;
        log.info("New unfriend message received from Gateway service. Profile identity: " + unfriendMessage.profileIdentity());
        profileService.unfriend(unfriendMessage.profileIdentity(), unfriendMessage.friendIdentity());
    }
}
