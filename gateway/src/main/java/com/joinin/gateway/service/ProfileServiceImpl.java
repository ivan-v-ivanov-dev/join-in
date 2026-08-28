package com.joinin.gateway.service;

import com.join_in.common_models.EditProfileGatewayRq;
import com.join_in.common_models.ProfileRpGatewayService;
import com.join_in.common_models.ProfileRpProfileService;
import com.join_in.kafka_models.KafkaMessage;
import com.join_in.kafka_models.messages.UpdateBackgroundImage;
import com.join_in.kafka_models.messages.UpdateProfileImage;
import com.join_in.kafka_models.messages.UpdateProfilePassword;
import com.joinin.gateway.mapper.ProfileMapper;
import com.joinin.gateway.service.contract.ProfileService;
import com.joinin.gateway.service.feign.ProfileServiceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProfileServiceImpl implements ProfileService {

    private final ProfileServiceClient profileServiceClient;
    private final ProfileMapper profileMapper;
    private final KafkaTemplate<String, KafkaMessage> kafkaTemplate;

    @Value("${spring.kafka.topic.update-profile-password}")
    private String updateProfilePasswordTopic;
    @Value("${spring.kafka.topic.update-profile}")
    private String updateProfileTopic;
    @Value("${spring.kafka.topic.update-profile-image}")
    private String updateProfileImageTopic;
    @Value("${spring.kafka.topic.update-background-image}")
    private String updateBackgroundImageTopic;

    @Override
    public ProfileRpGatewayService retrieveProfileByIdentity(String identity) {
        ProfileRpProfileService profileRpProfileService = profileServiceClient.retrieveProfileByIdentity(identity);
        log.info("Retrieve Profile by identity from Profile Service. Profile identity: " + profileRpProfileService.identity());
        return profileMapper.fromProfileRpProfileServicetoProfileRpGatewayService(profileRpProfileService);
    }

    @Override
    public String retrieveProfileNames(String identity) {
        String names = profileServiceClient.retrieveProfileNames(identity);
        log.info("Retrieve profile names: " + names);
        return names;
    }

    @Override
    public void editProfile(String identity, EditProfileGatewayRq editProfileGatewayRq, MultipartFile profileImage, MultipartFile backgroundImage) {
        if (editProfileGatewayRq.password() != null && editProfileGatewayRq.confirmPassword() != null) {
            KafkaMessage passwordMessage = new UpdateProfilePassword(identity, editProfileGatewayRq.password());
            kafkaTemplate.send(updateProfilePasswordTopic, passwordMessage);
            log.info("Send new password to Identity service for Profile: " + identity);
        }

        KafkaMessage updateProfileMessage = profileMapper.fromEditProfileGatewayRqtoUpdateProfile(identity, editProfileGatewayRq);
        kafkaTemplate.send(updateProfileTopic, updateProfileMessage);
        log.info("Send update profile to Profile service. Profile identity: " + identity);

        if (!profileImage.isEmpty()) {
            try {
                KafkaMessage updateProfileImageMessage = new UpdateProfileImage(identity, profileImage.getBytes());
                kafkaTemplate.send(updateProfileImageTopic, updateProfileImageMessage);
                log.error("Send new profile image to Media service for Profile: " + identity);
            } catch (IOException ioException) {
                log.error("Couldn't send profile image to Media service. Profile identity: " + identity);
            }
        }

        if (!backgroundImage.isEmpty()) {
            try {
                KafkaMessage updateBackgroundImageMessage = new UpdateBackgroundImage(identity, backgroundImage.getBytes());
                kafkaTemplate.send(updateBackgroundImageTopic, updateBackgroundImageMessage);
                log.error("Send new background image to Media service for Profile: " + identity);
            } catch (IOException ioException) {
                log.error("Couldn't send background image to Media service. Profile identity: " + identity);
            }
        }
    }
}
