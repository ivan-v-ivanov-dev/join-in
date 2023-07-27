package com.social.relationship.service;

import com.social.relationship.model.Friend;
import com.social.relationship.model.Profile;
import com.social.relationship.repository.ProfileRepository;
import com.social.relationship.service.contracts.ProfileService;
import com.social.relationship.service.feign.ImageClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

import static com.social.relationship.service.constants.LoggerConstants.*;

@Service
@Slf4j
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;
    private final ImageClient imageClient;

    public ProfileServiceImpl(ProfileRepository profileRepository,
                              ImageClient imageClient) {
        this.profileRepository = profileRepository;
        this.imageClient = imageClient;
    }

    @Override
    public Set<Friend> findFriendsByProfileIdentity(String identity) {
        Set<Friend> friends = new HashSet<>();
        Set<String> friendsIdentities = profileRepository.findFriendsByProfileIdentity(identity);
        log.info(String.format(RETRIEVE_FRIENDS_IDENTITIES_FOR_USER_TEMPLATE, identity));

        friendsIdentities.forEach(friendsIdentity ->
                friends.add(Friend.builder()
                        .profileIdentity(friendsIdentity)
                        .profileImage(imageClient.findProfileImage(friendsIdentity))
                        .build()));
        log.info(String.format(RETRIEVE_FRIENDS_PROFILE_IMAGES_FOR_USER_TEMPLATE, identity));
        return friends;
    }

    @Override
    public void save(Profile profile) {
        profileRepository.save(profile);
        log.info(String.format(NEW_USER_SAVED_IN_DATABASE_TEMPLATE, profile.getIdentity()));
    }

    @Override
    public int findFriendCountByProfileIdentity(String identity) {
        return profileRepository.findFriendCountByProfileIdentity(identity);
    }
}
