package com.social.notification.repository.contract;

import com.social.notification.model.Notification;

import java.util.List;

public interface NotificationRepository {
    void createCollection(String collection);

    void save(Notification notification, String collection);

    List<Notification> findUserNotifications(String collection);
}
