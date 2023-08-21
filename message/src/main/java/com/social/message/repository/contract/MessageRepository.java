package com.social.message.repository.contract;

import com.social.message.model.DirectChatMessage;
import com.social.message.model.User;

import java.util.List;

public interface MessageRepository {
    Boolean isFriendOnline(String identity);

    User findFriend(String identity);

    void userIsOnline(String identity);

    void userIsOffline(String identity);

    List<String> findUserDirectChatIdentities(String identity);

    List<DirectChatMessage> findDirectChatMessages(String collection);

    void saveMessage(DirectChatMessage directChatMessage, String collection);
}
