package com.social.message.repository.contract;

public interface MessageRepository {

    void userIsOnline(String identity);

    void userIsOffline(String identity);
}
