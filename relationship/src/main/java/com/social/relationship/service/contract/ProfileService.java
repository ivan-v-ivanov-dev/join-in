package com.social.relationship.service.contract;

import java.util.Set;

public interface ProfileService {
    void createProfile(String identity);

    Set<String> findFriendsByProfileIdentity(String identity);

//    void createFriendship(String senderIdentity, String recipientIdentity);
//
//    void createFriendshipRequest(String senderIdentity, String recipientIdentity);

}
