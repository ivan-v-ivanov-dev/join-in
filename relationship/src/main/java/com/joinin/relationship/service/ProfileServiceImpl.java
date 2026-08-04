package com.joinin.relationship.service;

import com.join_in.common_models.*;
import com.joinin.relationship.mapper.FamilyMemberMapper;
import com.joinin.relationship.mapper.ProfileRelationshipMapper;
import com.joinin.relationship.model.FamilyMember;
import com.joinin.relationship.model.ProfileNode;
import com.joinin.relationship.repository.ProfileRepository;
import com.joinin.relationship.service.contract.ProfileService;
import com.joinin.relationship.service.feign.MediaServiceClient;
import com.joinin.relationship.service.feign.MessageServiceClient;
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
    private final MessageServiceClient messageServiceClient;
    private final FamilyMemberMapper familyMemberMapper;

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

        List<ProfileImageRpMediaService> profileImageRpMediaServices = retrieveProfileImages(friends.stream().map(ProfileNode::getIdentity).toList());
        List<ProfileRpProfileNamesProfileService> profileRpProfileNamesProfileServices = retrieveProfileNames(friends.stream().map(ProfileNode::getIdentity).toList());
        List<ProfileOnlineStatusRpMessageService> profileOnlineStatuses = retrieveOnlineStatuses(friends.stream().map(ProfileNode::getIdentity).toList());

        return friends.stream()
                .map(friend -> profileRelationshipMapper.toProfileRpRelationshipService(
                        friend,
                        profileRpProfileNamesProfileServices,
                        profileImageRpMediaServices,
                        profileOnlineStatuses))
                .toList();
    }

    @Override
    public List<ProfileRpRelationshipService> retrieveFriendshipRequests(String identity) {
        List<ProfileNode> friends = profileRepository.findFriendshipRequestsByIdentity(identity);
        log.info("Retrieve friendship requests by an identity: " + identity);

        if (friends.isEmpty()) {
            log.info("Profile does not have friendship requests.");
            return new ArrayList<>();
        }

        List<ProfileImageRpMediaService> profileImageRpMediaServices = retrieveProfileImages(friends.stream().map(ProfileNode::getIdentity).toList());
        List<ProfileRpProfileNamesProfileService> profileRpProfileNamesProfileServices = retrieveProfileNames(friends.stream().map(ProfileNode::getIdentity).toList());
        List<ProfileOnlineStatusRpMessageService> profileOnlineStatuses = retrieveOnlineStatuses(friends.stream().map(ProfileNode::getIdentity).toList());

        return friends.stream()
                .map(friend -> profileRelationshipMapper.toProfileRpRelationshipService(
                        friend,
                        profileRpProfileNamesProfileServices,
                        profileImageRpMediaServices,
                        profileOnlineStatuses))
                .toList();
    }

    @Override
    public int retrieveProfilesFriendsCount(String identity) {
        int friendsCount = profileRepository.countAllFriendsByIdentity(identity);
        log.info("Retrieve profile friends count. Profile: " + identity);
        return friendsCount;
    }

    @Override
    public List<FamilyMemberRpRelationshipService> retrieveProfileFamilyMembers(String identity) {
        List<FamilyMember> allFamilyMembers = profileRepository.findAllFamilyMembers(identity);
        log.info("Retrieve all family members for a profile: " + identity);
        List<String> allFamilyMembersIdentities = allFamilyMembers
                .stream()
                .map(FamilyMember::getIdentity)
                .toList();
        List<ProfileImageRpMediaService> profileImages = retrieveProfileImages(allFamilyMembersIdentities);
        List<ProfileRpProfileNamesProfileService> profileNames = retrieveProfileNames(allFamilyMembersIdentities);
        return allFamilyMembers
                .stream()
                .map(familyMember -> familyMemberMapper.fromFamilyMembertoFamilyMemberRpRelationshipService(familyMember, profileImages, profileNames))
                .toList();
    }

    private List<ProfileOnlineStatusRpMessageService> retrieveOnlineStatuses(List<String> identities) {
        List<ProfileOnlineStatusRpMessageService> profileOnlineStatuses = messageServiceClient.retrieveProfilesOnlineStatuses(identities);
        log.info("Retrieve online statuses for all friendship requests from Message Service. Profile identities: " +
                profileOnlineStatuses.stream().map(ProfileOnlineStatusRpMessageService::identity).collect(Collectors.joining(", ")));
        return profileOnlineStatuses;
    }

    private List<ProfileRpProfileNamesProfileService> retrieveProfileNames(List<String> identities) {
        List<ProfileRpProfileNamesProfileService> profileRpProfileNamesProfileServices =
                profileServiceClient.retrieveProfilesNames(identities);
        log.info("Retrieve names for all friends from Profile Service. Profile identities: " +
                profileRpProfileNamesProfileServices.stream().map(ProfileRpProfileNamesProfileService::identity).collect(Collectors.joining(", ")));
        return profileRpProfileNamesProfileServices;
    }

    private List<ProfileImageRpMediaService> retrieveProfileImages(List<String> identities) {
        List<ProfileImageRpMediaService> profileImageRpMediaServices = mediaServiceClient.retrieveProfileImagesForProfiles(identities);
        log.info("Retrieve profiles images for all friends from Media Service. Profile identities: " +
                profileImageRpMediaServices.stream().map(ProfileImageRpMediaService::identity).collect(Collectors.joining(", ")));
        return profileImageRpMediaServices;
    }
}
