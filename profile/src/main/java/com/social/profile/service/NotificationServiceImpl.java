package com.social.profile.service;

import com.social.profile.model.Notification;
import com.social.profile.service.contracts.NotificationService;
import com.social.profile.service.feign.NotificationClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

import static com.social.profile.service.constants.LoggerConstants.RETRIEVE_USER_NOTIFICATIONS_FROM_NOTIFICATION_SERVICE_TEMPLATE;

@Service
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    private final NotificationClient notificationClient;

    public NotificationServiceImpl(NotificationClient notificationClient) {
        this.notificationClient = notificationClient;
    }

    @Override
    public List<Notification> findUserNotifications(String identity) {
        try {
            List<Notification> notifications = notificationClient.findUserNotifications(identity);
            log.info(String.format(RETRIEVE_USER_NOTIFICATIONS_FROM_NOTIFICATION_SERVICE_TEMPLATE, identity));
            return notifications;
        } catch (ResourceAccessException resourceAccessException) {
            log.error(resourceAccessException.getMessage());
            throw resourceAccessException;
        }
    }
}
