package com.social.profile.service;

import com.social.kafka.messages.FriendshipMessage;
import com.social.kafka.messages.contract.KafkaMessage;
import com.social.profile.model.Friend;
import com.social.profile.model.FriendSuggestion;
import com.social.profile.model.FriendshipRequest;
import com.social.profile.repository.contract.ProfileRepository;
import com.social.profile.service.contracts.KafkaMessageSender;
import com.social.profile.service.contracts.RelationshipService;
import com.social.profile.service.feign.RelationshipClient;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

import static com.social.profile.service.constants.ExceptionConstants.RELATIONSHIP_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN;
import static com.social.profile.service.constants.LoggerConstants.*;
import static com.social.profile.service.constants.ServiceConstants.AUTHOR_NAME_TEMPLATE;

@Service
@Slf4j
public class RelationshipServiceImpl implements RelationshipService {

    private final RelationshipClient relationshipClient;
    private final ProfileRepository profileRepository;
    private final KafkaMessageSender kafkaMessageSender;
    private final String acceptFriendshipTopic;
    private final String declineFriendshipTopic;
    private final String unfriendTopic;

    public RelationshipServiceImpl(RelationshipClient relationshipClient,
                                   ProfileRepository profileRepository,
                                   KafkaMessageSender kafkaMessageSender,
                                   @Value("${spring.kafka.topic.name.accept.friendship}") String acceptFriendshipTopic,
                                   @Value("${spring.kafka.topic.name.decline.friendship}") String declineFriendshipTopic,
                                   @Value("${spring.kafka.topic.name.unfriend}") String unfriendTopic) {
        this.relationshipClient = relationshipClient;
        this.profileRepository = profileRepository;
        this.kafkaMessageSender = kafkaMessageSender;
        this.acceptFriendshipTopic = acceptFriendshipTopic;
        this.declineFriendshipTopic = declineFriendshipTopic;
        this.unfriendTopic = unfriendTopic;
    }

    @Override
    public List<Friend> findFriends(String identity) {
        try {
            List<Friend> friends = relationshipClient.findFriends(identity);
            friends.forEach(friend -> {
                friend.setFirstName(profileRepository.findProfileFirstName(friend.getProfileIdentity()));
                friend.setLastName(profileRepository.findProfileLastName(friend.getProfileIdentity()));
            });
            log.info(String.format(RETRIEVE_ALL_FRIENDS_FROM_RELATION_SERVICE_TEMPLATE, identity));
            return friends;
        } catch (ResourceAccessException resourceAccessException) {
            log.error(resourceAccessException.getMessage());
            throw resourceAccessException;
        }
    }

    @Override
    public int findFriendsCount(String identity) {
        try {
            int friendsCount = relationshipClient.findFriendCount(identity);
            log.info(String.format(RETRIEVE_FRIENDS_COUNT_FROM_RELATION_SERVICE_TEMPLATE, identity));
            return friendsCount;
        } catch (FeignException feignException) {
            log.error(feignException.getMessage());
            throw new ResourceAccessException(RELATIONSHIP_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN);
        }
    }

    @Override
    public List<FriendshipRequest> findFriendshipRequests(String identity) {
        try {
            List<FriendshipRequest> friendshipRequests = relationshipClient.findFriendshipRequests(identity);
            log.info(String.format(RETRIEVE_FRIENDSHIP_REQUESTS_FROM_RELATION_SERVICE_TEMPLATE, identity));

            friendshipRequests.forEach(friendshipRequest -> {
                friendshipRequest.setFirstName(profileRepository.findProfileFirstName(friendshipRequest.getProfileIdentity()));
                friendshipRequest.setLastName(profileRepository.findProfileLastName(friendshipRequest.getProfileIdentity()));
            });
            return friendshipRequests;
        } catch (ResourceAccessException resourceAccessException) {
            log.error(resourceAccessException.getMessage());
            throw resourceAccessException;
        }
    }

    @Override
    public int findFriendshipRequestsCount(String identity) {
        try {
            int friendshipRequestsCount = relationshipClient.findFriendshipRequestsCount(identity);
            log.info(String.format(RETRIEVE_FRIENDSHIP_REQUEST_COUNT_FROM_RELATION_SERVICE_TEMPLATE, identity));
            return friendshipRequestsCount;
        } catch (FeignException feignException) {
            log.error(feignException.getMessage());
            throw new ResourceAccessException(RELATIONSHIP_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN);
        }
    }

    @Override
    public void confirmFriendship(String recipientUserIdentity, String senderUserIdentity) {
        KafkaMessage acceptFriendshipMessage = FriendshipMessage.builder()
                .recipientUserIdentity(recipientUserIdentity)
                .senderUserIdentity(senderUserIdentity)
                .build();

        kafkaMessageSender.send(acceptFriendshipMessage, acceptFriendshipTopic);
        log.info(String.format(ACCEPT_FRIENDSHIP_MESSAGE_CREATED_AND_SEND_TO_RELATIONSHIP_SERVICE_TOPIC_NAME_RECIPIENT_IDENTITY_TEMPLATE,
                acceptFriendshipTopic, recipientUserIdentity));
    }

    @Override
    public void declineFriendship(String recipientUserIdentity, String senderUserIdentity) {
        KafkaMessage declineFriendshipMessage = FriendshipMessage.builder()
                .recipientUserIdentity(recipientUserIdentity)
                .senderUserIdentity(senderUserIdentity)
                .build();

        kafkaMessageSender.send(declineFriendshipMessage, declineFriendshipTopic);
        log.info(String.format(DECLINE_FRIENDSHIP_MESSAGE_CREATED_AND_SEND_TO_RELATIONSHIP_SERVICE_TOPIC_NAME_RECIPIENT_IDENTITY_TEMPLATE,
                declineFriendshipTopic, recipientUserIdentity));
    }

    @Override
    public void unfriend(String recipientUserIdentity, String senderUserIdentity) {
        KafkaMessage unfriendMessage = FriendshipMessage.builder()
                .recipientUserIdentity(recipientUserIdentity)
                .senderUserIdentity(senderUserIdentity)
                .build();

        kafkaMessageSender.send(unfriendMessage, unfriendTopic);
        log.info(String.format(UNFRIEND_MESSAGE_CREATED_AND_SEND_TO_RELATIONSHIP_SERVICE_TOPIC_NAME_RECIPIENT_IDENTITY_TEMPLATE,
                unfriendTopic, recipientUserIdentity));
    }

    @Override
    public List<FriendSuggestion> findFriendSuggestions(String userIdentity) {
        try {
            List<FriendSuggestion> friendSuggestions = relationshipClient.findFriendSuggestions(userIdentity);
            friendSuggestions.forEach(friendSuggestion ->
                    friendSuggestion.setNames(String.format(AUTHOR_NAME_TEMPLATE,
                            profileRepository.findProfileFirstName(friendSuggestion.getProfileIdentity()),
                            profileRepository.findProfileLastName(friendSuggestion.getProfileIdentity()))));
            log.info(String.format(RETRIEVE_FRIEND_SUGGESTIONS_FROM_RELATIONSHIP_SERVICE_TEMPLATE, userIdentity));
            return friendSuggestions;
        } catch (ResourceAccessException resourceAccessException) {
            log.error(resourceAccessException.getMessage());
            throw resourceAccessException;
        }
    }
}
