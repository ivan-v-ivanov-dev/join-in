package com.social.notification.service.contract;

import com.social.model.dto.NotificationRp;

import java.util.List;

public interface NotificationService {
    void createCollection(String identity);

    List<NotificationRp> findProfileNotifications(String identity);
}
