package com.social.gateway.service.contract;

import com.social.model.dto.NotificationGatewayRp;

import java.util.List;

public interface NotificationService {
    List<NotificationGatewayRp> findNotificationsByProfileIdentity(String identity);
}
