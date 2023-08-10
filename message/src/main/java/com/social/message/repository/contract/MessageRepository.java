package com.social.message.repository.contract;

import com.social.message.model.User;

public interface MessageRepository {
    Boolean isFriendOnline(String identity);

    User findFriend (String identity);

    void userIsOnline(String identity);
}
