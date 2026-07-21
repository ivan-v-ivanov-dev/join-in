package com.joinin.reaction.service.listener;

import com.join_in.kafka_models.KafkaMessage;
import com.join_in.kafka_models.messages.NewRegisteredUserInfo;
import com.joinin.reaction.service.contract.ProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReactionServiceListener {

    private final ProfileService profileService;

    @KafkaListener(
            topics = "${spring.kafka.topic.new-registered-user-info}",
            groupId = "${spring.kafka.group-id}")
    public void newRegisteredUser(KafkaMessage message) {
        NewRegisteredUserInfo newRegisteredUserInfo = (NewRegisteredUserInfo) message;
        log.info("New registered user message received from Identity service. Profile identity: " + newRegisteredUserInfo.identity());
        profileService.saveProfile(newRegisteredUserInfo.identity());
    }
}
