package com.joinin.gateway.service.contract;

import com.join_in.common_models.NotificationRpGatewayService;

import java.util.List;

public interface NotificationService {
    List<NotificationRpGatewayService> retrieveProfileNotifications(String identity);
}
