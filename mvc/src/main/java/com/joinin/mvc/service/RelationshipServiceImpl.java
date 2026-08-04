package com.joinin.mvc.service;

import com.join_in.common_models.FamilyMemberRpGatewayService;
import com.join_in.common_models.ProfileFriendsRpGatewayService;
import com.joinin.mvc.mappers.FamilyMemberMapper;
import com.joinin.mvc.mappers.FriendsMapper;
import com.joinin.mvc.model.FamilyMember;
import com.joinin.mvc.model.Friend;
import com.joinin.mvc.service.contract.RelationshipService;
import com.joinin.mvc.service.feign.GatewayClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RelationshipServiceImpl implements RelationshipService {

    private final GatewayClient gatewayClient;
    private final FriendsMapper friendsMapper;
    private final FamilyMemberMapper familyMemberMapper;

    @Override
    public List<Friend> retrieveFriends(String identity) {
        List<ProfileFriendsRpGatewayService> friends = gatewayClient.retrieveFriends(identity);
        log.info("Retrieve friends from API Gateway for profile: " + identity);
        return friends
                .stream()
                .map(friendsMapper::fromProfileFriendsRpGatewayServicetoFriends)
                .toList();
    }

    @Override
    public List<Friend> retrieveFriendshipRequests(String identity) {
        List<ProfileFriendsRpGatewayService> friendshipRequests = gatewayClient.retrieveFriendshipRequests(identity);
        log.info("Retrieve friendship requests from API Gateway for profile: " + identity);
        return friendshipRequests
                .stream()
                .map(friendsMapper::fromProfileFriendsRpGatewayServicetoFriends)
                .toList();
    }

    @Override
    public int retrieveFriendsCount(String identity) {
        int friendsCount = gatewayClient.retrieveProfilesFriendsCount(identity);
        log.info("Retrieve friends count for profile: " + identity);
        return friendsCount;
    }

    @Override
    public List<FamilyMember> retrieveProfileFamilyMembers(String identity) {
        List<FamilyMemberRpGatewayService> familyMemberRpGatewayServices = gatewayClient.retrieveProfileFamilyMembers(identity);
        log.info("Retrieve family mmebers for profile: " + identity);
        return familyMemberRpGatewayServices
                .stream()
                .map(familyMemberMapper::fromFamilyMemberRpGatewayServicetoFamilyMember)
                .toList();
    }
}
