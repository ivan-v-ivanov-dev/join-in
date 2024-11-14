package com.social.gateway.service.contract;

import com.social.model.dto.FriendGatewayRp;
import com.social.model.dto.FriendshipRequestRp;

import java.util.List;

public interface RelationshipService {
    List<FriendGatewayRp> findProfileFriends(String identity);

    List<FriendshipRequestRp> findFriendshipRequestsByProfileIdentity(String identity);
}
