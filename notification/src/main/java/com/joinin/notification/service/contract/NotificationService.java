package com.joinin.notification.service.contract;

import com.join_in.common_models.NotificationRpNotificationService;

import java.util.List;

public interface NotificationService {
    void createCollection(String collection);

    List<NotificationRpNotificationService> retrieveProfileNotifications(String identity);
}
