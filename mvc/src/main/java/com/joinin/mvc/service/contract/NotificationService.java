package com.joinin.mvc.service.contract;

import com.joinin.mvc.model.Notification;

import java.util.List;

public interface NotificationService {
    List<Notification> retrieveProfileNotifications(String identity);
}
