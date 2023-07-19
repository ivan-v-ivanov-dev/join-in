package com.social.notification.service;

import com.social.notification.repository.contract.NotificationRepository;
import com.social.notification.service.contracts.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.social.notification.service.constants.LoggerConstants.NEW_COLLECTION_CREATED_TEMPLATE;
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
}
