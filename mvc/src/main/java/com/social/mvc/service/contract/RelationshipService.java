package com.social.mvc.service.contract;

import com.social.model.dto.FriendGatewayRp;

import java.util.List;

public interface RelationshipService {
    List<FriendGatewayRp> findProfileFriends(String identity);
}
