package com.joinin.gateway.service;

import com.join_in.kafka_models.KafkaMessage;
import com.join_in.kafka_models.messages.UpdateBackgroundImage;
import com.join_in.kafka_models.messages.UpdateProfileImage;
import com.join_in.kafka_models.messages.UploadAlbumImage;
import com.joinin.gateway.service.contract.MediaService;
import com.joinin.gateway.service.feign.MediaServiceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MediaServiceImpl implements MediaService {

    private final MediaServiceClient mediaServiceClient;
    private final KafkaTemplate<String, KafkaMessage> kafkaTemplate;

    @Value("${spring.kafka.topic.update-profile-image}")
    private String updateProfileImageTopic;
    @Value("${spring.kafka.topic.update-background-image}")
    private String updateBackgroundImageTopic;
    @Value("${spring.kafka.topic.upload-album-image}")
    private String uploadAlbumImageTopic;

    @Override
    public String retrieveProfileImage(String identity) {
        String profileImage = mediaServiceClient.retrieveProfileImage(identity);
        log.info("Retrieve profile image from Media service for profile: " + identity);
        return profileImage;
    }

    @Override
    public String retrieveProfileBackgroundImage(String identity) {
        String backgroundImage = mediaServiceClient.retrieveProfileBackgroundImage(identity);
        log.info("Retrieve profile background image from Media service for profile: " + identity);
        return backgroundImage;
    }

    @Override
    public List<String> retrieveProfileAlbumImages(String identity) {
        List<String> albumImages = mediaServiceClient.retrieveProfileAlbumImages(identity);
        log.info("Retrieve profile album images from Media service for profile: " + identity);
        return albumImages;
    }

    @Override
    public void updateProfileImage(String identity, MultipartFile profileImage) {
        if (!profileImage.isEmpty()) {
            try {
                KafkaMessage updateProfileImageMessage = new UpdateProfileImage(identity, profileImage.getBytes());
                kafkaTemplate.send(updateProfileImageTopic, updateProfileImageMessage);
                log.info("Send new profile image to Media service for Profile: " + identity);
            } catch (IOException ioException) {
                log.error("Couldn't send profile image to Media service. Profile identity: " + identity);
            }
        }
    }

    @Override
    public void updateBackgroundImage(String identity, MultipartFile backgroundImage) {
        if (!backgroundImage.isEmpty()) {
            try {
                KafkaMessage updateBackgroundImageMessage = new UpdateBackgroundImage(identity, backgroundImage.getBytes());
                kafkaTemplate.send(updateBackgroundImageTopic, updateBackgroundImageMessage);
                log.info("Send new background image to Media service for Profile: " + identity);
            } catch (IOException ioException) {
                log.error("Couldn't send background image to Media service. Profile identity: " + identity);
            }
        }
    }

    @Override
    public void uploadAlbumImage(String identity, MultipartFile albumImage) {
        if (!albumImage.isEmpty()) {
            try {
                KafkaMessage uploadAlbumImageMessage = new UploadAlbumImage(identity, albumImage.getBytes());
                kafkaTemplate.send(uploadAlbumImageTopic, uploadAlbumImageMessage);
                log.info("Send new album image to Media service for Profile: " + identity);
            } catch (IOException ioException) {
                log.error("Couldn't send album image to Media service. Profile identity: " + identity);
            }
        }
    }
}
