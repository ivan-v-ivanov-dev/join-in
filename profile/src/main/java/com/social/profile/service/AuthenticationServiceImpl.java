package com.social.profile.service;

import com.social.kafka.messages.UserLogout;
import com.social.kafka.messages.contract.KafkaMessage;
import com.social.profile.service.contracts.AuthenticationService;
import com.social.profile.service.contracts.KafkaMessageSender;
import com.social.profile.service.feign.LoginClient;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import static com.social.profile.service.constants.ExceptionConstants.AUTHENTICATION_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN;
import static com.social.profile.service.constants.LoggerConstants.USER_LOGGED_TEMPLATE;
import static com.social.profile.service.constants.LoggerConstants.USER_LOGOUT_MESSAGE_CREATED_AND_SEND_TO_MESSAGE_SERVICE_TOPIC_NAME_USER_IDENTITY_TEMPLATE;

@Service
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {

    private final LoginClient loginClient;
    private final KafkaMessageSender kafkaMessageSender;
    private final String userLogoutTopic;

    public AuthenticationServiceImpl(LoginClient loginClient,
                                     KafkaMessageSender kafkaMessageSender,
                                     @Value("${spring.kafka.topic.name.user.logout}") String userLogoutTopic) {
        this.loginClient = loginClient;
        this.kafkaMessageSender = kafkaMessageSender;
        this.userLogoutTopic = userLogoutTopic;
    }

    @Override
    public String login(String email, String password) {
        try {
            String userIdentity = loginClient.authenticate(email, password);
            log.info(String.format(USER_LOGGED_TEMPLATE, userIdentity));
            return userIdentity;
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
}
