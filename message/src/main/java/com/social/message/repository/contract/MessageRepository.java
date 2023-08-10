package com.social.message.repository.contract;

import com.social.message.model.ChatMessage;
import com.social.message.model.User;

import java.util.List;

public interface MessageRepository {
    Boolean isFriendOnline(String identity);

    User findFriend(String identity);

    void userIsOnline(String identity);

    List<String> findUserChatIdentities(String identity);

    List<ChatMessage> findChatMessages(String collection);
}
