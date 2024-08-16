package com.social.gateway.service;

import com.social.gateway.service.contract.AuthenticationService;
import com.social.gateway.service.contract.IdentityGenerator;
import com.social.gateway.service.contract.KafkaMessageSender;
import com.social.gateway.service.feign.AuthenticationClient;
import com.social.kafka.messages.RegisteredUserMessage;
import com.social.kafka.messages.UserLogin;
import com.social.kafka.messages.UserLogout;
import com.social.kafka.messages.contract.KafkaMessage;
import com.social.model.dto.RegisterUserRq;
import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import static com.social.gateway.service.constants.ExceptionConstants.AUTHENTICATION_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN;
import static com.social.gateway.service.constants.LoggerConstants.*;
import static java.lang.String.format;

@Service
@AllArgsConstructor
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationClient authenticationClient;
    private final IdentityGenerator identityGenerator;
    private final KafkaMessageSender kafkaMessageSender;
    @Value("${spring.kafka.topic.name.registered.user}")
    String registeredUserTopic;
    @Value("${spring.kafka.topic.name.user.logout}")
    String userLogoutTopic;
    @Value("${spring.kafka.topic.name.user.login}")
    private String userLoginTopic;

    @Override
    public String login(String email, String password) {
        try {
            String userIdentity = authenticationClient.login(email, password);
            log.info(format(USER_LOGGED_TEMPLATE, userIdentity));

            KafkaMessage userLogout = UserLogin.builder().identity(userIdentity).build();
            kafkaMessageSender.send(userLogout, userLoginTopic);
            log.info(String.format(USER_LOGIN_MESSAGE_SEND_TO_MESSAGE_SERVICE_TEMPLATE,
                    userLoginTopic, userIdentity));

            return userIdentity;
        } catch (IllegalArgumentException illegalArgumentException) {
            log.warn(illegalArgumentException.getMessage());
            throw illegalArgumentException;
        } catch (FeignException feignException) {
            log.error(feignException.getMessage());
            throw new ResourceAccessException(AUTHENTICATION_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN);
        }
    }

    @Override
    public void logout(String userIdentity) {
        KafkaMessage userLogout = UserLogout.builder().identity(userIdentity).build();
        kafkaMessageSender.send(userLogout, userLogoutTopic);
        log.info(String.format(USER_LOGOUT_MESSAGE_CREATED_AND_SEND_TO_MESSAGE_SERVICE_TOPIC_NAME_USER_IDENTITY_TEMPLATE,
                userLogoutTopic, userIdentity));
    }

    @Override
    public void register(RegisterUserRq registerUserRq) {
        String userIdentity = identityGenerator.generate(registerUserRq.getEmail());

        KafkaMessage registeredUserMessage = RegisteredUserMessage.builder()
                .identity(userIdentity)
                .email(registerUserRq.getEmail())
                .password(registerUserRq.getPassword())
                .build();

        kafkaMessageSender.send(registeredUserMessage, registeredUserTopic);
        log.info(format(NEW_REGISTERED_USER_CREATED_AND_SEND_TO_AUTHENTICATION_SERVICE_TOPIC_NAME_USER_IDENTITY_TEMPLATE,
                registeredUserTopic, userIdentity));
    }
}
