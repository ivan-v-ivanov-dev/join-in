package com.joinin.relationship.service;

import com.join_in.common_models.ProfileImageRpMediaService;
import com.join_in.common_models.ProfileRpProfileNamesProfileService;
import com.join_in.common_models.ProfileRpRelationshipService;
import com.joinin.relationship.mapper.ProfileRelationshipMapper;
import com.joinin.relationship.model.ProfileNode;
import com.joinin.relationship.repository.ProfileRepository;
import com.joinin.relationship.service.contract.ProfileService;
import com.joinin.relationship.service.feign.MediaServiceClient;
import com.joinin.relationship.service.feign.ProfileServiceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;
    private final MediaServiceClient mediaServiceClient;
    private final ProfileServiceClient profileServiceClient;
    private final ProfileRelationshipMapper profileRelationshipMapper;

    @Override
    public void createProfile(String identity) {
        ProfileNode user = ProfileNode.builder()
                .identity(identity)
                .build();
        ProfileNode savedProfileNode = profileRepository.save(user);
        log.info("User node saved in database. User identity: " + savedProfileNode.getIdentity());
    }

    @Override
    public List<ProfileRpRelationshipService> retrieveFriendsProfiles(String identity) {
        List<ProfileNode> friends = profileRepository.findAllFriendsByIdentity(identity);
        log.info("Retrieve friends by an identity: " + identity);

        if (friends.isEmpty()) {
            log.info("Profile does not have friends.");
            return new ArrayList<>();
        }

        List<ProfileImageRpMediaService> profileImageRpMediaServices =
                mediaServiceClient.retrieveProfileImagesForProfiles(friends.stream().map(ProfileNode::getIdentity).toList());
        log.info("Retrieve profiles images for all friends from Media Service. Profile identities: " +
                profileImageRpMediaServices.stream().map(ProfileImageRpMediaService::identity).collect(Collectors.joining(", ")));
        List<ProfileRpProfileNamesProfileService> profileRpProfileNamesProfileServices =
                profileServiceClient.retrieveProfilesNames(friends.stream().map(ProfileNode::getIdentity).toList());
        log.info("Retrieve names for all friends from Profile Service. Profile identities: " +
                profileRpProfileNamesProfileServices.stream().map(ProfileRpProfileNamesProfileService::identity).collect(Collectors.joining(", ")));
        return friends.stream()
                .map(friend -> profileRelationshipMapper.map(
                        friend,
                        profileRpProfileNamesProfileServices,
                        profileImageRpMediaServices))
                .toList();
    }
}
