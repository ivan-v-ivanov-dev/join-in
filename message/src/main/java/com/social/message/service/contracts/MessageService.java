package com.social.message.service.contracts;

public interface MessageService {
    void userIsOnline(String identity);

    void userIsOffline(String identity);

    boolean findUserOnlineStatus(String identity);
}
