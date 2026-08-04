package com.joinin.mvc.mappers;

import com.join_in.common_models.NotificationRpGatewayService;
import com.joinin.mvc.model.Notification;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

    Notification fromNotificationRpGatewayServicetoNotification(NotificationRpGatewayService notificationRpGatewayService);
}
