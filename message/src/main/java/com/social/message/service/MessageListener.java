package com.social.message.service;

import com.social.kafka.messages.UserLogin;
import com.social.kafka.messages.UserLogout;
import com.social.kafka.messages.contract.KafkaMessage;
import com.social.message.service.contracts.MessageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.social.message.service.constants.LoggerConstants.USER_LOGIN_MESSAGE_RECEIVED_FROM_AUTHENTICATION_SERVICE_TEMPLATE;
import static com.social.message.service.constants.LoggerConstants.USER_LOGOUT_MESSAGE_RECEIVED_FROM_PROFILE_SERVICE_TEMPLATE;

@Service
@AllArgsConstructor
@Slf4j
public class MessageListener {

    private final MessageService messageService;
    @Value("${spring.kafka.topic.name.user.login}")
    String userLoginTopic;
    @Value("${spring.kafka.topic.name.user.logout}")
    String userLogoutTopic;

    @KafkaListener(topics = "${spring.kafka.topic.name.user.login}", groupId = "${spring.kafka.group.id}")
    public void userLoginListener(KafkaMessage kafkaMessage) {
        UserLogin userLogin = (UserLogin) kafkaMessage;
        log.info(String.format(USER_LOGIN_MESSAGE_RECEIVED_FROM_AUTHENTICATION_SERVICE_TEMPLATE,
                userLoginTopic, userLogin.getIdentity()));

        messageService.userIsOnline(userLogin.getIdentity());
    }

    @KafkaListener(topics = "${spring.kafka.topic.name.user.logout}", groupId = "${spring.kafka.group.id}")
    public void userLogoutListener(KafkaMessage kafkaMessage) {
        UserLogout userLogout = (UserLogout) kafkaMessage;
        log.info(String.format(USER_LOGOUT_MESSAGE_RECEIVED_FROM_PROFILE_SERVICE_TEMPLATE,
                userLoginTopic, userLogout.getIdentity()));

        messageService.userIsOffline(userLogout.getIdentity());
    }
}
