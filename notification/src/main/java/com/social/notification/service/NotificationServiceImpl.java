package com.social.notification.service;

import com.social.notification.model.Notification;
import com.social.notification.repository.contract.NotificationRepository;
import com.social.notification.service.contracts.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

import static com.social.notification.service.constants.LoggerConstants.*;
import static com.social.notification.service.constants.ServiceConstants.COLLECTION_TEMPLATE;

@Service
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public void createCollection(String identity) {
        notificationRepository.createCollection(String.format(COLLECTION_TEMPLATE, identity));
        log.info(String.format(NEW_COLLECTION_CREATED_TEMPLATE, identity));
    }

    @Override
    public void save(Notification notification, Set<String> peopleToNotify) {
        peopleToNotify.forEach(person -> notificationRepository.save(notification, String.format(COLLECTION_TEMPLATE, person)));
        log.info(NOTIFICATIONS_SAVED_FOR_ALL_RELATED_USERS);
    }

    @Override
    public List<Notification> findUserNotifications(String userIdentity) {
        List<Notification> notifications = notificationRepository
                .findUserNotifications(String.format(COLLECTION_TEMPLATE, userIdentity));
        log.info(String.format(RETRIEVE_USER_NOTIFICATIONS_TEMPLATE, userIdentity));
        return notifications;
    }
}
