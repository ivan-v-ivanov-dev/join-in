package com.social.message.service.contract;

import com.social.message.model.DirectChat;
import com.social.message.model.User;

import java.util.Set;

public interface MessageService {
    Set<User> findUserOnlineFriends(String identity);

    void userIsOnline(String identity);

    void userIsOffline(String identity);

    Set<DirectChat> findUserDirectChatHistory(String identity);
}
