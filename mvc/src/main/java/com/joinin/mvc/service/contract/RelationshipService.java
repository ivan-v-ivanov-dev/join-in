package com.joinin.mvc.service.contract;

import com.joinin.mvc.model.Friends;

import java.util.List;

public interface RelationshipService {
    List<Friends> retrieveFriends(String identity);

    int retrieveFriendsCount(String identity);
}
