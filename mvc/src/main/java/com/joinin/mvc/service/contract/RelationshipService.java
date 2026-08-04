package com.joinin.mvc.service.contract;

import com.joinin.mvc.model.FamilyMember;
import com.joinin.mvc.model.Friend;

import java.util.List;

public interface RelationshipService {
    List<Friend> retrieveFriends(String identity);

    List<Friend> retrieveFriendshipRequests(String identity);

    int retrieveFriendsCount(String identity);

    List<FamilyMember> retrieveProfileFamilyMembers(String identity);
}
