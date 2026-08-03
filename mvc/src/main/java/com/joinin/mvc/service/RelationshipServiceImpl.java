package com.joinin.mvc.service;

import com.join_in.common_models.ProfileFriendsRpGatewayService;
import com.joinin.mvc.mappers.FriendsMapper;
import com.joinin.mvc.model.Friends;
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

    @Override
    public List<Friends> retrieveFriends(String identity) {
        List<ProfileFriendsRpGatewayService> friends = gatewayClient.retrieveFriends(identity);
        log.info("Retrieve friends from API Gateway for profile: " + identity);
        return friends
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
}
