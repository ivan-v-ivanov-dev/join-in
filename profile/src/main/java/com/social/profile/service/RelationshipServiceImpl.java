package com.social.profile.service;

import com.social.profile.model.dto.FriendsDto;
import com.social.profile.repository.contract.ProfileRepository;
import com.social.profile.service.contracts.RelationshipService;
import com.social.profile.service.feign.ImageClient;
import com.social.profile.service.feign.RelationshipClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.social.profile.service.constants.LoggerConstants.RETRIEVE_ALL_FRIENDS_FOR_PROFILE_TEMPLATE;

@Service
@Slf4j
public class RelationshipServiceImpl implements RelationshipService {

    private final RelationshipClient relationshipClient;
    private final ImageClient imageClient;
    private final ProfileRepository profileRepository;

    public RelationshipServiceImpl(RelationshipClient relationshipClient,
                                   ImageClient imageClient,
                                   ProfileRepository profileRepository) {
        this.relationshipClient = relationshipClient;
        this.imageClient = imageClient;
        this.profileRepository = profileRepository;
    }

    @Override
    public List<FriendsDto> findFriends(String identity) {
        List<FriendsDto> friends = new ArrayList<>();
        List<String> friendIdentities = relationshipClient.findFriends(identity);

        friendIdentities.forEach(friendIdentity -> {
            FriendsDto friend = FriendsDto.builder()
                    .profileImage(imageClient.findProfileImage(friendIdentity))
                    .firstName(profileRepository.findProfileFirstName(friendIdentity))
                    .lastName(profileRepository.findProfileLastName(friendIdentity))
                    .build();

            friends.add(friend);
        });
        log.info(String.format(RETRIEVE_ALL_FRIENDS_FOR_PROFILE_TEMPLATE, identity));

        return friends;
    }
}
