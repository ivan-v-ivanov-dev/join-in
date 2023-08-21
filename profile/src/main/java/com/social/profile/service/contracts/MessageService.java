package com.social.profile.service.contracts;

import com.social.profile.model.Chat;
import com.social.profile.model.OnlineFriend;

import java.util.List;

public interface MessageService {
    List<OnlineFriend> onlineFriends(String identity);

    List<Chat> findUserDirectChatHistory(String userIdentity);

    void send(String messageContent, String chatIdentity, String senderIdentity);

    List<Chat> findUserGroupChatHistory(String userIdentity);
}
