package com.social.profile.service;

import com.social.kafka.messages.RegisteredUserMessage;
import com.social.kafka.messages.contract.KafkaMessage;
import com.social.profile.model.Profile;
import com.social.profile.model.dto.RegisterDto;
import com.social.profile.repository.contract.ProfileRepository;
import com.social.profile.service.contracts.IdentityGeneratorService;
import com.social.profile.service.contracts.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static com.social.profile.service.constants.LoggerConstants.KAFKA_MESSAGE_FOR_NEW_REGISTERED_USER_CREATED_AND_SEND_TO_AUTHENTICATION_SERVICE_IN_TOPIC_TEMPLATE;
import static com.social.profile.service.constants.LoggerConstants.NEW_REGISTERED_USER_PROFILE_SAVED_IN_DATABASE_TEMPLATE;

@Service
@Slf4j
public class RegisterServiceImpl implements RegisterService {

    private final IdentityGeneratorService identityGenerator;
    private final KafkaTemplate<String, KafkaMessage> kafkaTemplate;
    private final ProfileRepository profileRepository;
    @Value("${spring.kafka.topic.name.registered.user}")
    private String kafkaTopicRegisteredUser;

    public RegisterServiceImpl(IdentityGeneratorService identityGenerator,
                               KafkaTemplate<String, KafkaMessage> kafkaTemplate,
                               ProfileRepository profileRepository) {
        this.identityGenerator = identityGenerator;
        this.kafkaTemplate = kafkaTemplate;
        this.profileRepository = profileRepository;
    }


    @Override
    public void register(RegisterDto registerDto) {
        String userIdentity = identityGenerator.generate(registerDto.getEmail());

        KafkaMessage kafkaMessage = RegisteredUserMessage.builder()
                .identity(userIdentity)
                .email(registerDto.getEmail())
                .password(registerDto.getPassword())
                .build();

        Message<KafkaMessage> message = MessageBuilder
                .withPayload(kafkaMessage)
                .setHeader(KafkaHeaders.TOPIC, kafkaTopicRegisteredUser)
                .build();

        kafkaTemplate.send(message);
        log.info(String.format(KAFKA_MESSAGE_FOR_NEW_REGISTERED_USER_CREATED_AND_SEND_TO_AUTHENTICATION_SERVICE_IN_TOPIC_TEMPLATE,
                userIdentity, kafkaTopicRegisteredUser));

        Profile profile = Profile.builder()
                .identity(userIdentity)
                .firstName(registerDto.getFirstName())
                .lastName(registerDto.getLastName())
                .email(registerDto.getEmail()).joined(LocalDate.now())
                .build();
        profileRepository.save(profile);
        log.info(String.format(NEW_REGISTERED_USER_PROFILE_SAVED_IN_DATABASE_TEMPLATE, userIdentity));
    }
}
