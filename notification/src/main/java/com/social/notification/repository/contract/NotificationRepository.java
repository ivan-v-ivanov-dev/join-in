package com.social.notification.repository.contract;

import com.social.notification.model.Notification;

public interface NotificationRepository {
    void createCollection(String collection);

    void save(Notification notification, String collection);
}
