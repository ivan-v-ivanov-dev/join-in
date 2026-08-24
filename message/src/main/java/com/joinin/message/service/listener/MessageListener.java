package com.joinin.message.service.listener;

import com.join_in.kafka_models.KafkaMessage;
import com.join_in.kafka_models.messages.NewRegisteredUserInfo;
import com.join_in.kafka_models.messages.UpdateProfileOfflineStatus;
import com.join_in.kafka_models.messages.UpdateProfileOnlineStatus;
import com.joinin.message.service.contract.ProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MessageListener {

    private final ProfileService profileService;

    @KafkaListener(
            topics = "${spring.kafka.topic.new-registered-user-info}",
            groupId = "${spring.kafka.group-id}")
    public void newRegisteredUser(KafkaMessage message) {
        NewRegisteredUserInfo newRegisteredUserInfo = (NewRegisteredUserInfo) message;
        log.info("New registered user message received from Identity service. Profile identity: " + newRegisteredUserInfo.identity());
        profileService.createProfileOffline(newRegisteredUserInfo.identity());
    }

    @KafkaListener(
            topics = "${spring.kafka.topic.update-profile-online-status}",
            groupId = "${spring.kafka.group-id}")
    public void updateProfileOnlineStatus(KafkaMessage message) {
        UpdateProfileOnlineStatus updateProfileOnlineStatus = (UpdateProfileOnlineStatus) message;
        log.info("Update profile online status message received from AI Gateway. Profile identity: " + updateProfileOnlineStatus.identity());
        profileService.updateProfileOnlineStatus(updateProfileOnlineStatus.identity());
    }

    @KafkaListener(
            topics = "${spring.kafka.topic.update-profile-offline-status}",
            groupId = "${spring.kafka.group-id}")
    public void updateProfileOfflineStatus(KafkaMessage message) {
        UpdateProfileOfflineStatus updateProfileOfflineStatus = (UpdateProfileOfflineStatus) message;
        log.info("Update profile offline status message received from AI Gateway. Profile identity: " + updateProfileOfflineStatus.identity());
        profileService.updateProfileOfflineStatus(updateProfileOfflineStatus.identity());
    }
}
