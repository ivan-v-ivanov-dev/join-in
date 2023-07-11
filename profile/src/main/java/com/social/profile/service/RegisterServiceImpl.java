package com.social.profile.service;

import com.social.kafka.messages.RegisteredUserMessage;
import com.social.kafka.messages.contract.KafkaMessage;
import com.social.profile.model.Profile;
import com.social.profile.model.dto.RegisterDto;
import com.social.profile.repository.contract.ProfileRepository;
import com.social.profile.service.contracts.IdentityGenerator;
import com.social.profile.service.contracts.KafkaMessageSender;
import com.social.profile.service.contracts.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static com.social.profile.service.constants.LoggerConstants.KAFKA_MESSAGE_FOR_NEW_REGISTERED_USER_CREATED_AND_SEND_TO_AUTHENTICATION_SERVICE_IN_TOPIC_TEMPLATE;
import static com.social.profile.service.constants.LoggerConstants.NEW_REGISTERED_USER_PROFILE_SAVED_IN_DATABASE_TEMPLATE;

@Service
@Slf4j
public class RegisterServiceImpl implements RegisterService {

    private final IdentityGenerator identityGenerator;
    private final KafkaMessageSender kafkaMessageSender;
    private final ProfileRepository profileRepository;
    private final String registeredUserTopic;

    public RegisterServiceImpl(IdentityGenerator identityGenerator,
                               KafkaMessageSender kafkaMessageSender,
                               ProfileRepository profileRepository,
                               @Value("${spring.kafka.topic.name.registered.user}") String registeredUserTopic) {
        this.identityGenerator = identityGenerator;
        this.kafkaMessageSender = kafkaMessageSender;
        this.registeredUserTopic = registeredUserTopic;
        this.profileRepository = profileRepository;
    }

    @Override
    public void register(RegisterDto registerDto) {
        String userIdentity = identityGenerator.generate(registerDto.getEmail());

        KafkaMessage registeredUserMessage = RegisteredUserMessage.builder()
                .identity(userIdentity)
                .email(registerDto.getEmail())
                .password(registerDto.getPassword())
                .build();

        kafkaMessageSender.send(registeredUserMessage, registeredUserTopic);
        log.info(String.format(KAFKA_MESSAGE_FOR_NEW_REGISTERED_USER_CREATED_AND_SEND_TO_AUTHENTICATION_SERVICE_IN_TOPIC_TEMPLATE,
                userIdentity, registeredUserTopic));

        Profile profile = Profile.builder()
                .identity(userIdentity)
                .firstName(registerDto.getFirstName())
                .lastName(registerDto.getLastName())
                .email(registerDto.getEmail())
                .joined(LocalDate.now())
                .build();
        profileRepository.save(profile);
        log.info(String.format(NEW_REGISTERED_USER_PROFILE_SAVED_IN_DATABASE_TEMPLATE, userIdentity));
    }
}
