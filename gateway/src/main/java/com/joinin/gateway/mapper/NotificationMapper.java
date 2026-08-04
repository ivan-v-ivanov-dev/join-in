package com.joinin.gateway.mapper;

import com.join_in.common_models.NotificationRpGatewayService;
import com.join_in.common_models.NotificationRpNotificationService;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationMapper {
    NotificationRpGatewayService fromNotificationRpNotificationServicetoNotificationRpGatewayService(NotificationRpNotificationService notificationRpNotificationService);
}
