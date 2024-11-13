package com.social.notification.adapter;

import com.social.model.dto.NotificationRp;
import com.social.notification.model.Notification;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import static com.social.notification.service.constants.ServiceConstants.*;

@Component
public class ApiGatewayAdapter {

    public List<NotificationRp> fromListNotificationToListNotificationRp(List<Notification> notifications) {
        return notifications.stream()
                .map(notification -> NotificationRp.builder()
                        .authorIdentity(notification.getAuthorIdentity())
                        .postIdentity(notification.getPostIdentity())
                        .notification(notification.getNotification())
                        .postedAgo(calculatePostedAgo(notification.getDate()))
                        .build())
                .toList();
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
