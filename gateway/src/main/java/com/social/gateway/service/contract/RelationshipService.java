package com.social.gateway.service.contract;

import com.social.model.dto.FriendGatewayRp;
import com.social.model.dto.FriendshipRequestGatewayRp;

import java.util.List;
import java.util.Set;

public interface RelationshipService {
    List<FriendGatewayRp> findProfileFriends(String identity);

    List<FriendshipRequestGatewayRp> findFriendshipRequestsByProfileIdentity(String identity);

    Set<String> findFriendsByProfileIdentity(String identity);
}
