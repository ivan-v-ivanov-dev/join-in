package com.social.profile.service.contracts;

import com.social.profile.model.Notification;

import java.util.List;

public interface NotificationService {
    List<Notification> findUserNotifications(String identity);
}
