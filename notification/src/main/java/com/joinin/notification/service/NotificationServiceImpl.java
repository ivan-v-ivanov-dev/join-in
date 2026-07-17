package com.joinin.notification.service;

import com.joinin.notification.repository.NotificationRepository;
import com.joinin.notification.service.contract.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    public void createCollection(String collection) {
        boolean created = notificationRepository.createCollection(collection);

        if (created) {
            log.info("Collection created: " + collection);
        } else {
            log.info("Collection already exists: " + collection);
        }

    }
}
