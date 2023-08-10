package com.social.message.service;

import com.social.message.model.Chat;
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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public Set<Chat> findUserChatHistory(String identity) {
        try {
            Set<Chat> userChatHistory = new HashSet<>();
            List<String> userChatIdentities = messageRepository.findUserChatIdentities(identity);
            userChatIdentities.forEach(chatIdentity -> {
                Chat chat = Chat.builder()
                        .chatIdentity(chatIdentity)
                        .chatMessages(new ArrayList<>())
                        .build();
                chat.setChatMessages(messageRepository.findChatMessages(String.format(COLLECTION_TEMPLATE, chatIdentity)));
                chat.getChatMessages().forEach(chatMessage -> {
                    chatMessage.setSenderProfileImage(imageClient.findProfileImage(chatMessage.getSenderIdentity()));
                    chatMessage.setReceiverProfileImage(imageClient.findProfileImage(chatMessage.getReceiverIdentity()));
                    chatMessage.setPostedAgo(calculatePostedAgo(chatMessage.getDate()));
                });
                userChatHistory.add(chat);
            });
            return userChatHistory;
        } catch (FeignException feignException) {
            log.error(feignException.getMessage());
            throw new ResourceAccessException(IMAGE_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN);
        }
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
            if (now.isBefore(postDate.plusDays(2))) {
                return ONE_DAY_AGO;
            }

            Period period = Period.between(postDate, now);
            int days = period.getDays();
            return String.format(SEVERAL_DAYS_AGO_TEMPLATE, days);
        }
    }
}
