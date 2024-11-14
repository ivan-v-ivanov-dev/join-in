package com.social.mvc.service.contract;

import com.social.model.dto.NotificationGatewayRp;

import java.util.List;

public interface NotificationService {
    List<NotificationGatewayRp> findProfileNotifications(String identity);
}
