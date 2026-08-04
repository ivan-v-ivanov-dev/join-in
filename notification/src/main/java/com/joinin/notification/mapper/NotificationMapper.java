package com.joinin.notification.mapper;

import com.join_in.common_models.NotificationRpNotificationService;
import com.join_in.common_models.ProfileImageRpMediaService;
import com.join_in.common_models.ProfileRpProfileNamesProfileService;
import com.joinin.notification.model.Notification;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationMapper {

    public NotificationRpNotificationService fromNotificationtoNotificationRpNotificationService(Notification notification,
                                                                                                 List<ProfileImageRpMediaService> profileImages) {
        if (notification == null) {
            return null;
        }

        String authorProfileImage = profileImages
                .stream()
                .filter(e -> e.identity().equals(notification.getAuthorIdentity()))
                .map(ProfileImageRpMediaService::profileImage)
                .findFirst()
                .orElse("No image");

        return new NotificationRpNotificationService(
                notification.getAuthorIdentity(),
                authorProfileImage,
                notification.getPostIdentity(),
                notification.getContent(),
                calculatePostedAgo(notification.getCreatedAt())
        );
    }

    private String calculatePostedAgo(LocalDateTime createdAt) {
        if (createdAt == null) {
            return "";
        }

        Duration duration = Duration.between(createdAt, LocalDateTime.now());

        if (duration.isNegative()) {
            return "just now";
        }

        long seconds = duration.getSeconds();

        if (seconds < 60) {
            return "just now";
        }

        long minutes = duration.toMinutes();

        if (minutes < 60) {
            return formatTime(minutes, "minute");
        }

        long hours = duration.toHours();

        if (hours < 24) {
            return formatTime(hours, "hour");
        }

        long days = duration.toDays();

        if (days < 7) {
            return formatTime(days, "day");
        }

        long weeks = days / 7;

        if (weeks < 5) {
            return formatTime(weeks, "week");
        }

        long months = days / 30;

        if (months < 12) {
            return formatTime(months, "month");
        }

        long years = days / 365;

        return formatTime(years, "year");
    }

    private String formatTime(long value, String unit) {
        return value + " " + unit + (value == 1 ? "" : "s") + " ago";
    }
}
