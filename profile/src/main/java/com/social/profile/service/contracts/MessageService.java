package com.social.profile.service.contracts;

import com.social.profile.model.OnlineFriend;

import java.util.Set;

public interface MessageService {
    Set<OnlineFriend> onlineFriends(String identity);
}
