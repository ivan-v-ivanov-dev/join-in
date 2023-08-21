package com.social.profile.service;

import com.social.kafka.messages.NewChatMessage;
import com.social.kafka.messages.contract.KafkaMessage;
import com.social.profile.model.DirectChat;
import com.social.profile.model.OnlineFriend;
import com.social.profile.repository.contract.ProfileRepository;
import com.social.profile.service.contracts.KafkaMessageSender;
import com.social.profile.service.contracts.MessageService;
import com.social.profile.service.feign.MessageClient;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.social.profile.service.constants.ExceptionConstants.MESSAGE_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN;
import static com.social.profile.service.constants.LoggerConstants.NEW_CHAT_MESSAGE_CREATED_AND_SEND_TO_MESSAGE_SERVICE_TOPIC_NAME_MESSAGE_SENDER_IDENTITY_TEMPLATE;
import static com.social.profile.service.constants.LoggerConstants.RETRIEVE_ONLINE_FRIENDS_FROM_MESSAGE_SERVICE_TEMPLATE;
import static com.social.profile.service.constants.ServiceConstants.AUTHOR_NAME_TEMPLATE;

@Service
@Slf4j
public class MessageServiceImpl implements MessageService {

    private final ProfileRepository profileRepository;
    private final MessageClient messageClient;
    private final KafkaMessageSender kafkaMessageSender;
    private final String newChatMessageTopic;

    public MessageServiceImpl(ProfileRepository profileRepository,
                              MessageClient messageClient,
                              KafkaMessageSender kafkaMessageSender,
                              @Value("${spring.kafka.topic.name.new.chat.message}") String newChatMessageTopic) {
        this.profileRepository = profileRepository;
        this.messageClient = messageClient;
        this.kafkaMessageSender = kafkaMessageSender;
        this.newChatMessageTopic = newChatMessageTopic;
    }

    @Override
    public List<OnlineFriend> onlineFriends(String identity) {
        try {
            Set<OnlineFriend> onlineFriends = new LinkedHashSet<>(messageClient.findUserOnlineFriends(identity));
            log.info(String.format(RETRIEVE_ONLINE_FRIENDS_FROM_MESSAGE_SERVICE_TEMPLATE, identity));
            onlineFriends.forEach(friend -> friend.setNames(String.format(AUTHOR_NAME_TEMPLATE,
                    profileRepository.findProfileFirstName(friend.getIdentity()),
                    profileRepository.findProfileLastName(friend.getIdentity()))));
            return onlineFriends
                    .stream()
                    .sorted(Comparator.comparing(OnlineFriend::getNames))
                    .collect(Collectors.toList());
        } catch (FeignException | ResourceAccessException exception) {
            log.error(exception.getMessage());
            throw new ResourceAccessException(MESSAGE_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN);
        }
    }

    @Override
    public List<DirectChat> findUserDirectChatHistory(String userIdentity) {
        try {
            return messageClient.findUserDirectChatHistory(userIdentity);
        } catch (FeignException | ResourceAccessException exception) {
            log.error(exception.getMessage());
            throw new ResourceAccessException(MESSAGE_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN);
        }
    }

    @Override
    public void send(String messageContent, String chatIdentity, String senderIdentity) {
        KafkaMessage newChatMessage = NewChatMessage.builder()
                .messageContent(messageContent)
                .chatIdentity(chatIdentity)
                .senderIdentity(senderIdentity)
                .date(LocalDate.now().toString())
                .build();

        kafkaMessageSender.send(newChatMessage, newChatMessageTopic);
        log.info(String.format(NEW_CHAT_MESSAGE_CREATED_AND_SEND_TO_MESSAGE_SERVICE_TOPIC_NAME_MESSAGE_SENDER_IDENTITY_TEMPLATE,
                newChatMessageTopic, senderIdentity));
    }
}
