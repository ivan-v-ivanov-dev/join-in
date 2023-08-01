package com.social.notification.service.contracts;

import com.social.notification.model.Notification;

import java.util.List;
import java.util.Set;

public interface NotificationService {
    void createCollection(String identity);

    void save(Notification notification, Set<String> peopleToNotify);

    List<Notification> findUserNotifications(String userIdentity);
}
