package com.joinin.gateway.service;

import com.join_in.common_models.RegisterUserMVCRq;
import com.join_in.kafka_models.KafkaMessage;
import com.join_in.kafka_models.messages.RegisterNewUser;
import com.joinin.gateway.service.contract.IdentityService;
import com.joinin.gateway.service.feign.IdentityServiceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class IdentityServiceImpl implements IdentityService {

    private final IdentityServiceClient identityServiceClient;
    private final KafkaTemplate<String, KafkaMessage> kafkaTemplate;

    @Value("${spring.kafka.topic.register-new-user}")
    private String registerNewUserTopic;

    @Override
    public boolean isEmailUnique(String email) {
        boolean isEmailUnique = identityServiceClient.isEmailUnique(email);
        log.info("Identity service Feign client :: Check whether email is unique: " + email);
        return isEmailUnique;
    }

    @Override
    public void registerUser(RegisterUserMVCRq registerUserMVCRq) {
        KafkaMessage registerNewUser =
                new RegisterNewUser(registerUserMVCRq.getFirstName(), registerUserMVCRq.getLastName(), registerUserMVCRq.getEmail(), registerUserMVCRq.getPassword());
        kafkaTemplate.send(registerNewUserTopic, registerNewUser);
        log.info("New registered user message request received from API Gateway and sent in topic " + registerNewUserTopic);
    }

}
