package com.joinin.media.service.listener;

import com.join_in.kafka_models.KafkaMessage;
import com.join_in.kafka_models.messages.NewRegisteredUserInfo;
import com.join_in.kafka_models.messages.UpdateBackgroundImage;
import com.join_in.kafka_models.messages.UpdateProfileImage;
import com.join_in.kafka_models.messages.UploadAlbumImage;
import com.joinin.media.service.contract.AlbumImageService;
import com.joinin.media.service.contract.ProfileService;
import com.joinin.media.service.contract.S3MediaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MediaServiceListener {

    private final ProfileService profileService;
    private final S3MediaService s3MediaService;
    private final AlbumImageService albumImageService;

    @KafkaListener(
            topics = "${spring.kafka.topic.new-registered-user-info}",
            groupId = "${spring.kafka.group-id}")
    public void newRegisteredUser(KafkaMessage message) {
        NewRegisteredUserInfo newRegisteredUserInfo = (NewRegisteredUserInfo) message;
        log.info("New registered user message received from Identity service. User identity: " + newRegisteredUserInfo.identity());
        profileService.saveUserWithDefaultPictures(newRegisteredUserInfo.identity());
    }

    @KafkaListener(
            topics = "${spring.kafka.topic.update-profile-image}",
            groupId = "${spring.kafka.group-id}")
    public void updateProfileImage(KafkaMessage message) {
        UpdateProfileImage updateProfileImage = (UpdateProfileImage) message;
        log.info("New update profile image message received from API Gateway service. Profile identity: " + updateProfileImage.identity());
        profileService.updateProfileImage(updateProfileImage.identity());
        s3MediaService.updateProfileImage(updateProfileImage.identity(), updateProfileImage.profileImage());
    }

    @KafkaListener(
            topics = "${spring.kafka.topic.update-background-image}",
            groupId = "${spring.kafka.group-id}")
    public void updateBackgroundImage(KafkaMessage message) {
        UpdateBackgroundImage updateBackgroundImage = (UpdateBackgroundImage) message;
        log.info("New update background image message received from API Gateway service. Profile identity: " + updateBackgroundImage.identity());
        profileService.updateBackgroundImage(updateBackgroundImage.identity());
        s3MediaService.updateBackgroundImage(updateBackgroundImage.identity(), updateBackgroundImage.backgroundImage());
    }

    @KafkaListener(
            topics = "${spring.kafka.topic.upload-album-image}",
            groupId = "${spring.kafka.group-id}")
    public void uploadAlbumImage(KafkaMessage message) {
        UploadAlbumImage uploadAlbumImage = (UploadAlbumImage) message;
        log.info("New upload album image message received from API Gateway service. Profile identity: " + uploadAlbumImage.identity());
        albumImageService.uploadAlbumImage(uploadAlbumImage.identity(), uploadAlbumImage.albumImage());
    }
}
