package com.joinin.notification.controller;

import com.join_in.common_models.NotificationRpNotificationService;
import com.joinin.notification.service.contract.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping("/profile/{identity}")
    public List<NotificationRpNotificationService> retrieveProfileNotifications(@PathVariable("identity") String identity) {
        return notificationService.retrieveProfileNotifications(identity);
    }
}
