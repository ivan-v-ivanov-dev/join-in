package com.joinin.gateway.service.contract;

import com.join_in.common_models.ProfileFriendsRpGatewayService;

import java.util.List;

public interface RelationshipService {
    List<ProfileFriendsRpGatewayService> retrieveFriends(String identity);
}
