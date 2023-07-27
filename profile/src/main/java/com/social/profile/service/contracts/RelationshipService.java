package com.social.profile.service.contracts;

import com.social.profile.model.Friend;
import com.social.profile.model.FriendshipRequest;

import java.util.List;

public interface RelationshipService {
    List<Friend> findFriends(String identity);

    int findFriendsCount(String identity);

    List<FriendshipRequest> findFriendshipRequests(String identity);

    int findFriendshipRequestsCount(String identity);
}
