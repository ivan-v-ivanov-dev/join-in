package com.social.message.service;

import com.social.message.model.DirectChat;
import com.social.message.model.DirectChatMessage;
import com.social.message.model.User;
import com.social.message.repository.contract.MessageRepository;
import com.social.message.service.contract.MessageService;
import com.social.message.service.feign.ImageClient;
import com.social.message.service.feign.RelationshipClient;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

import static com.social.message.service.constants.ExceptionConstants.IMAGE_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN;
import static com.social.message.service.constants.ExceptionConstants.RELATIONSHIP_OR_IMAGE_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN;
import static com.social.message.service.constants.LoggerConstants.*;
import static com.social.message.service.constants.ServiceConstants.*;

@Service
@Slf4j
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final RelationshipClient relationshipClient;
    private final ImageClient imageClient;

    public MessageServiceImpl(MessageRepository messageRepository,
                              RelationshipClient relationshipClient,
                              ImageClient imageClient) {
        this.messageRepository = messageRepository;
        this.relationshipClient = relationshipClient;
        this.imageClient = imageClient;
    }

    @Override
    public Set<User> findUserOnlineFriends(String identity) {
        try {
            Set<String> userFriends = relationshipClient.findFriendsIdentities(identity);
            Set<User> onlineFriends = new HashSet<>();
            userFriends.forEach(friendIdentity -> {
                if (messageRepository.isFriendOnline(friendIdentity)) {
                    User user = messageRepository.findFriend(friendIdentity);
                    user.setProfileImage(imageClient.findProfileImage(friendIdentity));
                    onlineFriends.add(user);
                }
            });
            log.info(String.format(RETRIEVE_ONLINE_FRIENDS_FOR_USER_TEMPLATE, identity));
            return onlineFriends;
        } catch (FeignException feignException) {
            log.error(feignException.getMessage());
            throw new ResourceAccessException(RELATIONSHIP_OR_IMAGE_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN);
        }
    }

    @Override
    public void userIsOnline(String identity) {
        messageRepository.userIsOnline(identity);
        log.info(String.format(SET_USER_ONLINE_TEMPLATE, identity));
    }

    @Override
    public void userIsOffline(String identity) {
        messageRepository.userIsOffline(identity);
        log.info(String.format(SET_USER_OFFLINE_TEMPLATE, identity));
    }

    @Override
    public List<DirectChat> findUserDirectChatHistory(String identity) {
        try {
            List<DirectChat> userDirectChatHistory = new ArrayList<>();
            List<String> userChatIdentities = messageRepository.findUserDirectChatIdentities(identity);
            userChatIdentities.forEach(chatIdentity -> {
                DirectChat directChat = DirectChat.builder()
                        .chatIdentity(chatIdentity)
                        .directChatMessages(new ArrayList<>())
                        .build();
                directChat.setDirectChatMessages(messageRepository.findDirectChatMessages(String.format(COLLECTION_TEMPLATE, chatIdentity)));
                directChat.getDirectChatMessages().forEach(chatMessage -> {
                    chatMessage.setSenderProfileImage(imageClient.findProfileImage(chatMessage.getSenderIdentity()));
                    chatMessage.setPostedAgo(calculatePostedAgo(chatMessage.getDate()));
                });
                directChat.getDirectChatMessages().sort(Comparator.comparing(DirectChatMessage::getDate));
                userDirectChatHistory.add(directChat);
            });
            return userDirectChatHistory;
        } catch (FeignException feignException) {
            log.error(feignException.getMessage());
            throw new ResourceAccessException(IMAGE_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN);
        }
    }

    @Override
    public void saveMessage(String chatIdentity, String senderIdentity, String messageContent, LocalDate date) {
        DirectChatMessage directChatMessage = DirectChatMessage.builder()
                .senderIdentity(senderIdentity)
                .content(messageContent)
                .date(date)
                .build();
        messageRepository.saveMessage(directChatMessage, String.format(COLLECTION_TEMPLATE, chatIdentity));
        log.info(NEW_CHAT_MESSAGE_SAVED_IN_DATABASE);
    }

    private String calculatePostedAgo(LocalDate postDate) {
        LocalDate now = LocalDate.now();

        if (now.isAfter(postDate.plusYears(1))) {
            if (now.isBefore(postDate.plusYears(2))) {
                return ONE_YEAR_AGO;
            }

            Period period = Period.between(postDate, now);
            int years = period.getYears();
            return String.format(SEVERAL_YEARS_AGO_TEMPLATE, years);
        } else if (now.isAfter(postDate.plusMonths(1))) {
            if (now.isBefore(postDate.plusMonths(2))) {
                return ONE_MONTH_AGO;
            }

            Period period = Period.between(postDate, now);
            int months = period.getMonths();
            return String.format(SEVERAL_MONTHS_AGO_TEMPLATE, months);
        } else {
            if (now.isBefore(postDate.plusDays(1))) {
                return ONE_DAY_AGO;
            }

            Period period = Period.between(postDate, now);
            int days = period.getDays();
            return String.format(SEVERAL_DAYS_AGO_TEMPLATE, days);
        }
    }
}
