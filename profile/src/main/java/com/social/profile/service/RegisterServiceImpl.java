package com.social.profile.service;

import com.social.kafka.messages.RegisteredUserMessage;
import com.social.kafka.messages.contract.KafkaMessage;
import com.social.profile.model.Profile;
import com.social.profile.model.Register;
import com.social.profile.repository.contract.ProfileRepository;
import com.social.profile.service.contracts.IdentityGenerator;
import com.social.profile.service.contracts.KafkaMessageSender;
import com.social.profile.service.contracts.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static com.social.profile.service.constants.LoggerConstants.NEW_REGISTERED_USER_CREATED_AND_SEND_TO_AUTHENTICATION_SERVICE_TOPIC_NAME_USER_IDENTITY_TEMPLATE;
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
    public void register(Register register) {
        String userIdentity = identityGenerator.generate(register.getEmail());

        KafkaMessage registeredUserMessage = RegisteredUserMessage.builder()
                .identity(userIdentity)
                .email(register.getEmail())
                .password(register.getPassword())
                .build();

        kafkaMessageSender.send(registeredUserMessage, registeredUserTopic);
        log.info(String.format(NEW_REGISTERED_USER_CREATED_AND_SEND_TO_AUTHENTICATION_SERVICE_TOPIC_NAME_USER_IDENTITY_TEMPLATE,
                registeredUserTopic, userIdentity));

        Profile profile = Profile.builder()
                .identity(userIdentity)
                .firstName(register.getFirstName())
                .lastName(register.getLastName())
                .email(register.getEmail())
                .joined(LocalDate.now())
                .build();
        profileRepository.save(profile);
        log.info(String.format(NEW_REGISTERED_USER_PROFILE_SAVED_IN_DATABASE_TEMPLATE, userIdentity));
    }
}
