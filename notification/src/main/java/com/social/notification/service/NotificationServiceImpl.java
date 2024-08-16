package com.social.notification.service;

import com.social.notification.repository.contract.NotificationRepository;
import com.social.notification.service.contract.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.social.notification.service.constants.LoggerConstants.NEW_COLLECTION_CREATED_TEMPLATE;
import static com.social.notification.service.constants.ServiceConstants.COLLECTION_TEMPLATE;
import static java.lang.String.format;

@Service
@AllArgsConstructor
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Override
    public void createCollection(String identity) {
        notificationRepository.createCollection(format(COLLECTION_TEMPLATE, identity));
        log.info(format(NEW_COLLECTION_CREATED_TEMPLATE, format(COLLECTION_TEMPLATE, identity)));
    }
}
