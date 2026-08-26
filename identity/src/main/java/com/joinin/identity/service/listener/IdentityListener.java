package com.joinin.identity.service.listener;

import com.join_in.kafka_models.KafkaMessage;
import com.join_in.kafka_models.messages.RegisterNewUser;
import com.join_in.kafka_models.messages.UpdateProfilePassword;
import com.joinin.identity.mapper.RegisterProfileMapper;
import com.joinin.identity.service.contract.ProfileService;
import com.joinin.identity.service.contract.RegisterProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class IdentityListener {

    private final RegisterProfileService registerProfileService;
    private final ProfileService profileService;
    private final RegisterProfileMapper registerUserMapper;

    @KafkaListener(
            topics = "${spring.kafka.topic.register-new-user}",
            groupId = "${spring.kafka.group-id}")
    public void registeredUser(KafkaMessage message) {
        RegisterNewUser registerNewUserMessage = (RegisterNewUser) message;
        log.info("New user register message received. Profile first name: " + registerNewUserMessage.firstName());
        registerProfileService.register(registerUserMapper.fromRegisterNewUsertoRegisterProfile(registerNewUserMessage));
    }

    @KafkaListener(
            topics = "${spring.kafka.topic.update-profile-password}",
            groupId = "${spring.kafka.group-id}")
    public void updateProfilePassword(KafkaMessage message) {
        UpdateProfilePassword updateProfilePasswordMessage = (UpdateProfilePassword) message;
        log.info("Update password message received. Profile identity: " + updateProfilePasswordMessage.identity());
        profileService.updateProfilePassword(updateProfilePasswordMessage.identity(), updateProfilePasswordMessage.password());
    }
}
