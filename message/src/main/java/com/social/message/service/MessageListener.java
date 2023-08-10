package com.social.message.service;

import com.social.kafka.messages.UserLogin;
import com.social.kafka.messages.contract.KafkaMessage;
import com.social.message.service.contract.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.social.message.service.constants.LoggerConstants.USER_LOGIN_MESSAGE_RECEIVED_FROM_AUTHENTICATION_SERVICE_TEMPLATE;

@Service
@Slf4j
public class MessageListener {

    private final MessageService messageService;
    private final String userLoginTopic;

    public MessageListener(MessageService messageService,
                           @Value("${spring.kafka.topic.name.user.login}") String userLoginTopic) {
        this.messageService = messageService;
        this.userLoginTopic = userLoginTopic;
    }

    @KafkaListener(topics = "${spring.kafka.topic.name.user.login}", groupId = "${spring.kafka.group.id}")
    public void userLoginListener(KafkaMessage kafkaMessage) {
        UserLogin userLogin = (UserLogin) kafkaMessage;
        log.info(String.format(USER_LOGIN_MESSAGE_RECEIVED_FROM_AUTHENTICATION_SERVICE_TEMPLATE,
                userLoginTopic, userLogin.getIdentity()));

        messageService.userIsOnline(userLogin.getIdentity());
    }
}
