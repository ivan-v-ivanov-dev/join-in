package com.joinin.identity.service.listener;

import com.join_in.kafka_models.KafkaMessage;
import com.join_in.kafka_models.messages.RegisterNewUser;
import com.joinin.identity.mapper.RegisterUserMapper;
import com.joinin.identity.service.contract.RegisterUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class IdentityListener {

    private final RegisterUserService registerUserService;
    private final RegisterUserMapper registerUserMapper;

    @KafkaListener(
            topics = "${spring.kafka.topic.register-new-user}",
            groupId = "${spring.kafka.group-id}")
    public void registeredUser(KafkaMessage message) {
        RegisterNewUser registerNewUserMessage = (RegisterNewUser) message;
        log.info("New user register message received. User first name: " + registerNewUserMessage.firstName());
        registerUserService.register(registerUserMapper.fromRegisterNewUsertoRegisterUser(registerNewUserMessage));
    }
}
