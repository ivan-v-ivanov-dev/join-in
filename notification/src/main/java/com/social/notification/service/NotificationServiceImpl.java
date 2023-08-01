package com.social.notification.service;

import com.social.notification.model.Notification;
import com.social.notification.repository.contract.NotificationRepository;
import com.social.notification.service.contracts.NotificationService;
import com.social.notification.service.feign.ImageClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Set;

import static com.social.notification.service.constants.LoggerConstants.*;
import static com.social.notification.service.constants.ServiceConstants.*;

@Service
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final ImageClient imageClient;

    public NotificationServiceImpl(NotificationRepository notificationRepository,
                                   ImageClient imageClient) {
        this.notificationRepository = notificationRepository;
        this.imageClient = imageClient;
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

        notifications.forEach(notification -> {
            notification.setAuthorProfileImage(imageClient.findProfileImage(notification.getAuthorIdentity()));
            notification.setPostedAgo(calculatePostedAgo(notification.getDate()));
        });

        log.info(String.format(RETRIEVE_USER_NOTIFICATIONS_TEMPLATE, userIdentity));
        return notifications;
    }

    private String calculatePostedAgo(LocalDate postDate) {
        LocalDate now = LocalDate.now();

        if (now.isAfter(postDate.plusYears(1))) {
            if (now.isBefore(postDate.plusYears(2))) {
                return ONE_YEAR_AGO;
            }

            Period period = Period.between(postDate, now);
            int years = period.getYears();
            return String.format(SEVERAL_YEARS_AGO_TEMPLATE, years);
        } else if (now.isAfter(postDate.plusMonths(1))) {
            if (now.isBefore(postDate.plusMonths(2))) {
                return ONE_MONTH_AGO;
            }

            Period period = Period.between(postDate, now);
            int months = period.getMonths();
            return String.format(SEVERAL_MONTHS_AGO_TEMPLATE, months);
        } else {
            if (now.isBefore(postDate.plusDays(2))) {
                return ONE_DAY_AGO;
            }

            Period period = Period.between(postDate, now);
            int days = period.getDays();
            return String.format(SEVERAL_DAYS_AGO_TEMPLATE, days);
        }
    }
}
