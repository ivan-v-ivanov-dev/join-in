package com.social.notification.service;

import com.social.model.dto.NotificationRp;
import com.social.notification.adapter.ApiGatewayAdapter;
import com.social.notification.model.Notification;
import com.social.notification.repository.contract.NotificationRepository;
import com.social.notification.service.contract.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.social.notification.service.constants.LoggerConstants.NEW_COLLECTION_CREATED_TEMPLATE;
import static com.social.notification.service.constants.LoggerConstants.RETRIEVE_USER_NOTIFICATIONS_TEMPLATE;
import static com.social.notification.service.constants.ServiceConstants.COLLECTION_TEMPLATE;
import static java.lang.String.format;

@Service
@AllArgsConstructor
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final ApiGatewayAdapter adapter;

    @Override
    public void createCollection(String identity) {
        notificationRepository.createCollection(format(COLLECTION_TEMPLATE, identity));
        log.info(format(NEW_COLLECTION_CREATED_TEMPLATE, format(COLLECTION_TEMPLATE, identity)));
    }

    @Override
    public List<NotificationRp> findProfileNotifications(String identity) {
        List<Notification> notifications = notificationRepository.findProfileNotifications(format(COLLECTION_TEMPLATE, identity));
        log.info(String.format(RETRIEVE_USER_NOTIFICATIONS_TEMPLATE, identity));
        return adapter.fromListNotificationToListNotificationRp(notifications);
    }
}
