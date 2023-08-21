package com.social.message.service;

import com.social.kafka.messages.NewChatMessage;
import com.social.kafka.messages.UserLogin;
import com.social.kafka.messages.UserLogout;
import com.social.kafka.messages.contract.KafkaMessage;
import com.social.message.service.contract.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static com.social.message.service.constants.LoggerConstants.*;

@Service
@Slf4j
public class MessageListener {

    private final MessageService messageService;
    private final String userLoginTopic;
    private final String userLogoutTopic;
    private final String newChatMessageTopic;

    public MessageListener(MessageService messageService,
                           @Value("${spring.kafka.topic.name.user.login}") String userLoginTopic,
                           @Value("${spring.kafka.topic.name.user.logout}") String userLogoutTopic,
                           @Value("${spring.kafka.topic.name.new.chat.message}") String newChatMessageTopic) {
        this.messageService = messageService;
        this.userLoginTopic = userLoginTopic;
        this.userLogoutTopic = userLogoutTopic;
        this.newChatMessageTopic = newChatMessageTopic;
    }

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

    @KafkaListener(topics = "${spring.kafka.topic.name.new.chat.message}", groupId = "${spring.kafka.group.id}")
    public void newChatMessageListener(KafkaMessage kafkaMessage) {
        NewChatMessage newChatMessage = (NewChatMessage) kafkaMessage;
        log.info(String.format(NEW_CHAT_MESSAGE_RECEIVED_FROM_PROFILE_SERVICE_TEMPLATE,
                newChatMessageTopic, newChatMessage.getSenderIdentity()));

        messageService.saveMessage(newChatMessage.getChatIdentity(), newChatMessage.getSenderIdentity(),
                newChatMessage.getMessageContent(), LocalDate.parse(newChatMessage.getDate()));
    }
}
