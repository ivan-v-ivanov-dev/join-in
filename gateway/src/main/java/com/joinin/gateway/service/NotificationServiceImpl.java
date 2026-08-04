package com.joinin.gateway.service;

import com.join_in.common_models.NotificationRpGatewayService;
import com.join_in.common_models.NotificationRpNotificationService;
import com.joinin.gateway.mapper.NotificationMapper;
import com.joinin.gateway.service.contract.NotificationService;
import com.joinin.gateway.service.feign.NotificationServiceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    private final NotificationServiceClient notificationServiceClient;
    private final NotificationMapper notificationMapper;

    @Override
    public List<NotificationRpGatewayService> retrieveProfileNotifications(String identity) {
        List<NotificationRpNotificationService> notificationRpNotificationServices = notificationServiceClient.retrieveProfileNotifications(identity);
        log.info("Retrieve profile notifications: " + identity);
        return notificationRpNotificationServices
                .stream()
                .map(notificationMapper::fromNotificationRpNotificationServicetoNotificationRpGatewayService)
                .toList();
    }
}
