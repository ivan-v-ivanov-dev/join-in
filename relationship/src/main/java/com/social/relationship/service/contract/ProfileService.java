package com.social.relationship.service.contract;

public interface ProfileService {
    void createProfile(String identity);

    void createFriendship(String senderIdentity, String recipientIdentity);

    void createFriendshipRequest(String senderIdentity, String recipientIdentity);

}
