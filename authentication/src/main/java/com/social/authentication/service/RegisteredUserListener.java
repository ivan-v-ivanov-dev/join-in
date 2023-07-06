package com.social.authentication.service;

import com.social.authentication.model.User;
import com.social.authentication.service.contract.RegisterService;
import com.social.authentication.util.contracts.PasswordEncoder;
import com.social.kafka.messages.RegisteredUserMessage;
import com.social.kafka.messages.contract.KafkaMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.social.authentication.service.constants.LoggerConstants.NEW_REGISTERED_USER_MESSAGE_RECEIVED_FROM_PROFILE_SERVICE_TEMPLATE;

@Service
@Slf4j
public class RegisteredUserListener {

    private final PasswordEncoder passwordEncoder;
    private final RegisterService registerService;
    @Value("${spring.kafka.topic.name.registered.user}")
    private String kafkaTopic;

    public RegisteredUserListener(PasswordEncoder passwordEncoder,
                                  RegisterService registerService) {
        this.passwordEncoder = passwordEncoder;
        this.registerService = registerService;
    }

    @KafkaListener(topics = "${spring.kafka.topic.name.registered.user}", groupId = "${spring.kafka.topic.name.registered.user}")
    public void shopListener(KafkaMessage kafkaMessage) {
        RegisteredUserMessage registeredUserMessage = (RegisteredUserMessage) kafkaMessage;
        log.info(String.format(NEW_REGISTERED_USER_MESSAGE_RECEIVED_FROM_PROFILE_SERVICE_TEMPLATE,
                registeredUserMessage.getIdentity(), kafkaTopic));

        User user = User.builder()
                .email(registeredUserMessage.getEmail())
                .password(passwordEncoder.encode(registeredUserMessage.getPassword()))
                .identity(registeredUserMessage.getIdentity())
                .build();

        registerService.save(user);
    }
}
