package com.joinin.mvc.service;

import com.join_in.common_models.NotificationRpGatewayService;
import com.joinin.mvc.mappers.NotificationMapper;
import com.joinin.mvc.model.Notification;
import com.joinin.mvc.service.contract.NotificationService;
import com.joinin.mvc.service.feign.GatewayClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final GatewayClient gatewayClient;
    private final NotificationMapper notificationMapper;

    @Override
    public List<Notification> retrieveProfileNotifications(String identity) {
        List<NotificationRpGatewayService> notificationRpGatewayServices = gatewayClient.retrieveProfileNotifications(identity);
        log.info("Retrieve notification from API Gateway for profile: " + identity);
        return notificationRpGatewayServices
                .stream()
                .map(notificationMapper::fromNotificationRpGatewayServicetoNotification)
                .toList();
    }
}
