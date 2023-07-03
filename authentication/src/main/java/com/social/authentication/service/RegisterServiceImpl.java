package com.social.authentication.service;

import com.social.authentication.model.User;
import com.social.authentication.model.dto.RegisterDto;
import com.social.authentication.repository.UserRepository;
import com.social.authentication.service.contract.RegisterService;
import com.social.authentication.util.PasswordEncoderImpl;
import com.social.authentication.util.contracts.IdentityGenerator;
import com.social.authentication.util.contracts.PasswordEncoder;
import com.social.kafka.messages.RegisteredUserMessage;
import com.social.kafka.messages.contract.KafkaMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static com.social.authentication.service.constants.ExceptionConstants.USER_EMAIL_IS_ALREADY_IN_USE;
import static com.social.authentication.service.constants.LoggerConstants.NEW_REGISTERED_USER_MESSAGE_SEND_TO_PROFILE_SERVICE_TEMPLATE;
import static com.social.authentication.service.constants.LoggerConstants.NEW_REGISTERED_USER_SAVED_IN_DATABASE_TEMPLATE;

@Service
@Slf4j
public class RegisterServiceImpl implements RegisterService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final IdentityGenerator identityGenerator;
    private final KafkaTemplate<String, KafkaMessage> kafkaTemplate;
    @Value("${spring.kafka.topic.name}")
    private String topicName;

    public RegisterServiceImpl(UserRepository userRepository,
                               PasswordEncoderImpl passwordEncoder,
                               IdentityGenerator identityGenerator,
                               KafkaTemplate<String, KafkaMessage> kafkaTemplate) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.identityGenerator = identityGenerator;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void register(RegisterDto registerDto) {
        if (userRepository.findByEmail(registerDto.getEmail()) != null) {
            throw new IllegalArgumentException(USER_EMAIL_IS_ALREADY_IN_USE);
        }

        User user = User.builder()
                .email(registerDto.getEmail())
                .password(passwordEncoder.encode(registerDto.getPassword()))
                .identity(identityGenerator.generate(registerDto.getEmail()))
                .build();

        user = userRepository.save(user);
        log.info(String.format(NEW_REGISTERED_USER_SAVED_IN_DATABASE_TEMPLATE, user.getIdentity()));

        KafkaMessage kafkaMessage = RegisteredUserMessage.builder()
                .identity(user.getIdentity())
                .firstName(registerDto.getFirstName())
                .lastName(registerDto.getLastName())
                .email(registerDto.getEmail())
                .joined(LocalDate.now())
                .build();

        Message<KafkaMessage> message = MessageBuilder
                .withPayload(kafkaMessage)
                .setHeader(KafkaHeaders.TOPIC, topicName)
                .build();

        kafkaTemplate.send(message);
        log.info(String.format(NEW_REGISTERED_USER_MESSAGE_SEND_TO_PROFILE_SERVICE_TEMPLATE, user.getIdentity(), topicName));
    }
}
