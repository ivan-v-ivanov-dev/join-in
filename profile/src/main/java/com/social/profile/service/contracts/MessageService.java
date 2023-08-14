package com.social.profile.service.contracts;

import com.social.profile.model.DirectChat;
import com.social.profile.model.OnlineFriend;

import java.util.List;

public interface MessageService {
    List<OnlineFriend> onlineFriends(String identity);

    List<DirectChat> findUserDirectChatHistory(String userIdentity);
}
