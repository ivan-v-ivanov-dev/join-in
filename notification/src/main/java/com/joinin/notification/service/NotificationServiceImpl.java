package com.joinin.notification.service;

import com.join_in.common_models.NotificationRpNotificationService;
import com.join_in.common_models.ProfileImageRpMediaService;
import com.join_in.common_models.ProfileRpProfileNamesProfileService;
import com.joinin.notification.mapper.NotificationMapper;
import com.joinin.notification.model.Notification;
import com.joinin.notification.repository.NotificationRepository;
import com.joinin.notification.service.contract.NotificationService;
import com.joinin.notification.service.feign.MediaServiceClient;
import com.joinin.notification.service.feign.ProfileServiceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;
    private final MediaServiceClient mediaServiceClient;
    private final ProfileServiceClient profileServiceClient;

    public void createCollection(String collection) {
        boolean created = notificationRepository.createCollection(collection);

        if (created) {
            log.info("Collection created: " + collection);
        } else {
            log.info("Collection already exists: " + collection);
        }

    }

    @Override
    public List<NotificationRpNotificationService> retrieveProfileNotifications(String identity) {
        List<Notification> notifications = notificationRepository.retrieveNotificationForProfile(identity);
        List<String> profileIdentities = notifications.stream().map(Notification::getAuthorIdentity).toList();
        List<ProfileImageRpMediaService> profileImages = mediaServiceClient.retrieveProfileImagesForProfiles(profileIdentities);
        List<ProfileRpProfileNamesProfileService> profileNames = profileServiceClient.retrieveProfilesNames(profileIdentities);
        log.info("Retrieve profile notifications: " + identity);
        return notifications
                .stream()
                .map(e -> notificationMapper.fromNotificationtoNotificationRpNotificationService(e, profileImages, profileNames))
                .toList();
    }
}
