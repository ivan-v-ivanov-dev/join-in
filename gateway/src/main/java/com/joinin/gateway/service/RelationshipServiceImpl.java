package com.joinin.gateway.service;

import com.join_in.common_models.FamilyMemberRpGatewayService;
import com.join_in.common_models.FamilyMemberRpRelationshipService;
import com.join_in.common_models.ProfileFriendsRpGatewayService;
import com.join_in.common_models.ProfileRpRelationshipService;
import com.joinin.gateway.mapper.FamilyMemberMapper;
import com.joinin.gateway.mapper.ProfileMapper;
import com.joinin.gateway.service.contract.RelationshipService;
import com.joinin.gateway.service.feign.RelationshipServiceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RelationshipServiceImpl implements RelationshipService {

    private final RelationshipServiceClient relationshipServiceClient;
    private final ProfileMapper profileMapper;
    private final FamilyMemberMapper familyMemberMapper;

    @Override
    public List<ProfileFriendsRpGatewayService> retrieveFriends(String identity) {
        List<ProfileRpRelationshipService> friendsProfiles = relationshipServiceClient.retrieveFriendsProfiles(identity);
        log.info("Retrieve friends from Relationship service. Profile identity: " + identity);
        return friendsProfiles
                .stream()
                .map(profileMapper::fromProfileRpRelationshipServicetoProfileFriendsRpGatewayService)
                .toList();
    }

    @Override
    public List<ProfileFriendsRpGatewayService> retrieveFriendshipRequests(String identity) {
        List<ProfileRpRelationshipService> friendshipRequests = relationshipServiceClient.retrieveFriendshipRequests(identity);
        log.info("Retrieve friendship requests from Relationship service. Profile identity: " + identity);
        return friendshipRequests
                .stream()
                .map(profileMapper::fromProfileRpRelationshipServicetoProfileFriendsRpGatewayService)
                .toList();
    }

    @Override
    public int retrieveFriendsCount(String identity) {
        int friendsCount = relationshipServiceClient.retrieveProfilesFriendsCount(identity);
        log.info("Retrieve friends count for profile: " + identity);
        return friendsCount;
    }

    @Override
    public List<FamilyMemberRpGatewayService> retrieveProfileFamilyMembers(String identity) {
        List<FamilyMemberRpRelationshipService> familyMemberRpRelationshipServices = relationshipServiceClient.retrieveProfileFamilyMembers(identity);
        log.info("Retrieve family members for profile: " + identity);
        return familyMemberRpRelationshipServices
                .stream()
                .map(familyMemberMapper::fromFamilyMemberRpRelationshipServicetoFamilyMemberRpGatewayService)
                .toList();
    }
}
