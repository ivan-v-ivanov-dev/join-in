package com.joinin.identity.service;

import com.join_in.kafka_models.KafkaMessage;
import com.join_in.kafka_models.messages.NewRegisteredUserInfo;
import com.joinin.identity.model.RegisterUser;
import com.joinin.identity.model.User;
import com.joinin.identity.repository.UserRepository;
import com.joinin.identity.service.contract.RegisterUserService;
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
public class RegisterUserServiceImpl implements RegisterUserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final KafkaTemplate<String, KafkaMessage> kafkaTemplate;

    @Value("${spring.kafka.topic.new-registered-user-info}")
    private String newRegisteredUserInfo;

    @Override
    public void register(RegisterUser registerUser) {
        User user = User.builder()
                .identity(calculateIdentity(registerUser))
                .email(registerUser.getEmail())
                .password(passwordEncoder.encode(registerUser.getPassword()))
                .build();

        User savedUser = userRepository.save(user);
        log.info("User saved in database. User identity: " + savedUser.getIdentity());

        KafkaMessage newRegisteredUser = new NewRegisteredUserInfo(user.getIdentity(), registerUser.getFirstName(), registerUser.getLastName());
        kafkaTemplate.send(newRegisteredUserInfo, newRegisteredUser);
        log.info("Send new registered user info to other services in topic: " + newRegisteredUserInfo);
    }

    private String calculateIdentity(RegisterUser registerUser) {
        try {
            StringBuffer data = new StringBuffer()
                    .append(registerUser.getFirstName().trim().toLowerCase())
                    .append("-")
                    .append(registerUser.getLastName().trim().toLowerCase())
                    .append("-")
                    .append(registerUser.getEmail().trim().toLowerCase())
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
