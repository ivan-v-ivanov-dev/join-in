package com.social.message.service;

import com.social.message.model.User;
import com.social.message.repository.contract.MessageRepository;
import com.social.message.service.contract.MessageService;
import com.social.message.service.feign.ImageClient;
import com.social.message.service.feign.RelationshipClient;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.HashSet;
import java.util.Set;

import static com.social.message.service.constants.ExceptionConstants.RELATIONSHIP_OR_IMAGE_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN;
import static com.social.message.service.constants.LoggerConstants.RETRIEVE_ONLINE_FRIENDS_FOR_USER_TEMPLATE;
import static com.social.message.service.constants.LoggerConstants.SET_USER_ONLINE_TEMPLATE;

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
}
