package com.social.authentication.service;

import com.social.authentication.model.User;
import com.social.authentication.repository.UserRepository;
import com.social.authentication.service.contract.IdentityGenerator;
import com.social.authentication.service.contract.KafkaMessageSender;
import com.social.authentication.service.contract.PasswordEncoder;
import com.social.authentication.service.contract.RegisterService;
import com.social.kafka.messages.NewUserMessage;
import com.social.kafka.messages.contract.KafkaMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static com.social.authentication.service.constants.ExceptionConstants.USER_ALREADY_EXISTS;
import static com.social.authentication.service.constants.ExceptionConstants.USER_ALREADY_EXISTS_WITH_EMAIL_TEMPLATE;
import static com.social.authentication.service.constants.LoggerConstants.NEW_REGISTERED_USER_SAVED_IN_DATABASE_TEMPLATE;
import static com.social.authentication.service.constants.LoggerConstants.NEW_USER_MESSAGE_SEND_TO_MULTIPLE_SERVICES_TEMPLATE;
import static java.lang.String.format;

@Service
@Slf4j
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final IdentityGenerator identityGenerator;
    private final KafkaMessageSender kafkaMessageSender;
    @Value("${spring.kafka.topic.name.new.user}")
    private String newUserTopic;

    @Override
    public void register(String email, String password) {
        if (userRepository.findByEmail(email) != null) {
            log.warn(format(USER_ALREADY_EXISTS_WITH_EMAIL_TEMPLATE, email));
            throw new IllegalArgumentException(USER_ALREADY_EXISTS);
        }

        User savedUser = userRepository.save(User.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .identity(identityGenerator.generate(email)).build());
        log.info(format(NEW_REGISTERED_USER_SAVED_IN_DATABASE_TEMPLATE, savedUser.getIdentity()));

        KafkaMessage newUser = NewUserMessage.builder()
                .identity(savedUser.getIdentity())
                .build();

        kafkaMessageSender.send(newUser, newUserTopic);
        log.info(format(NEW_USER_MESSAGE_SEND_TO_MULTIPLE_SERVICES_TEMPLATE,
                newUserTopic, savedUser.getIdentity()));
    }
}
