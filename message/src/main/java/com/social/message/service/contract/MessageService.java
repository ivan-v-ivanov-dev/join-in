package com.social.message.service.contract;

import com.social.message.model.Chat;
import com.social.message.model.User;

import java.util.Set;

public interface MessageService {
    Set<User> findUserOnlineFriends(String identity);

    void userIsOnline(String identity);

    Set<Chat> findUserChatHistory(String identity);
}
