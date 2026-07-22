package com.joinin.identity.service;

import com.join_in.kafka_models.KafkaMessage;
import com.join_in.kafka_models.messages.NewRegisteredUserInfo;
import com.joinin.identity.model.Profile;
import com.joinin.identity.model.RegisterProfile;
import com.joinin.identity.repository.ProfileRepository;
import com.joinin.identity.service.contract.RegisterProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.HexFormat;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class RegisterProfileServiceImpl implements RegisterProfileService {

    private final PasswordEncoder passwordEncoder;
    private final ProfileRepository profileRepository;
    private final KafkaTemplate<String, KafkaMessage> kafkaTemplate;

    @Value("${spring.kafka.topic.new-registered-user-info}")
    private String newRegisteredUserInfo;

    @Override
    public void register(RegisterProfile registerProfile) {
        Profile profile = Profile.builder()
                .identity(calculateIdentity(registerProfile))
                .email(registerProfile.getEmail())
                .password(passwordEncoder.encode(registerProfile.getPassword()))
                .build();

        Profile savedProfile = profileRepository.save(profile);
        log.info("Profile saved in database. Profile identity: " + savedProfile.getIdentity());

        KafkaMessage newRegisteredUser = new NewRegisteredUserInfo(profile.getIdentity(), registerProfile.getFirstName(), registerProfile.getLastName());
        kafkaTemplate.send(newRegisteredUserInfo, newRegisteredUser);
        log.info("Send new registered profile info to other services in topic: " + newRegisteredUserInfo);
    }

    private String calculateIdentity(RegisterProfile registerProfile) {
        try {
            StringBuffer data = new StringBuffer()
                    .append(registerProfile.getFirstName().trim().toLowerCase())
                    .append("-")
                    .append(registerProfile.getLastName().trim().toLowerCase())
                    .append("-")
                    .append(registerProfile.getEmail().trim().toLowerCase())
                    .append("-")
                    .append(LocalDateTime.now());

            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

            byte[] hash = messageDigest.digest(data.toString().getBytes(StandardCharsets.UTF_8));

            return HexFormat.of().formatHex(hash);
        } catch (NoSuchAlgorithmException e) {
            log.error("Unable to generate SHA-256 hash.", e);
        }
        return UUID.randomUUID().toString();
    }
}
