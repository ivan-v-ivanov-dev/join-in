package com.social.notification.service.contracts;

import com.social.notification.model.Notification;

import java.util.List;

public interface NotificationService {
    void createCollection(String identity);

    void save(Notification notification, List<String> friends);
}
