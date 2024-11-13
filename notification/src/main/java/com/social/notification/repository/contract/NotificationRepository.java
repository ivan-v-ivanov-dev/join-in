package com.social.notification.repository.contract;

import com.social.notification.model.Notification;

import java.util.List;

public interface NotificationRepository {
    void createCollection(String collection);

    List<Notification> findProfileNotifications(String format);
}
