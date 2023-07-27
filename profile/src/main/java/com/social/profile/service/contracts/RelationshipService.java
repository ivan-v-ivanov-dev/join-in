package com.social.profile.service.contracts;

import com.social.profile.model.Friend;

import java.util.List;

public interface RelationshipService {
    List<Friend> findFriends(String identity);

    int findFriendsCount(String identity);
}
