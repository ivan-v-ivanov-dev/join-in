package com.social.relationship.service.contracts;

import com.social.relationship.model.Friend;
import com.social.relationship.model.FriendshipRequest;
import com.social.relationship.model.Profile;

import java.util.List;
import java.util.Set;

public interface ProfileService {

    Set<Friend> findFriendsByProfileIdentity(String identity);

    void save(Profile profile);

    int findFriendCountByProfileIdentity(String identity);

    List<FriendshipRequest> findFriendshipRequest(String identity);

    int findFriendshipRequestCountByProfileIdentity(String identity);

    void acceptFriendship(String senderUserIdentity, String recipientUserIdentity);
}
