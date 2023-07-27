package com.social.profile.service;

import com.social.profile.model.Friend;
import com.social.profile.repository.contract.ProfileRepository;
import com.social.profile.service.contracts.RelationshipService;
import com.social.profile.service.feign.RelationshipClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.social.profile.service.constants.LoggerConstants.RETRIEVE_ALL_FRIENDS_FROM_RELATION_SERVICE_TEMPLATE;
import static com.social.profile.service.constants.LoggerConstants.RETRIEVE_FRIENDS_COUNT_FROM_RELATION_SERVICE_TEMPLATE;

@Service
@Slf4j
public class RelationshipServiceImpl implements RelationshipService {

    private final RelationshipClient relationshipClient;
    private final ProfileRepository profileRepository;

    public RelationshipServiceImpl(RelationshipClient relationshipClient,
                                   ProfileRepository profileRepository) {
        this.relationshipClient = relationshipClient;
        this.profileRepository = profileRepository;
    }

    @Override
    public List<Friend> findFriends(String identity) {
        List<Friend> friends = relationshipClient.findFriends(identity);
        friends.forEach(friend -> {
            friend.setFirstName(profileRepository.findProfileFirstName(friend.getProfileIdentity()));
            friend.setLastName(profileRepository.findProfileLastName(friend.getProfileIdentity()));
        });
        log.info(String.format(RETRIEVE_ALL_FRIENDS_FROM_RELATION_SERVICE_TEMPLATE, identity));
        return friends;
    }

    @Override
    public int findFriendsCount(String identity) {
        int friendsCount = relationshipClient.findFriendCount(identity);
        log.info(String.format(RETRIEVE_FRIENDS_COUNT_FROM_RELATION_SERVICE_TEMPLATE, identity));
        return friendsCount;
    }
}
