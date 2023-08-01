package com.social.notification.controller;

import com.social.notification.model.Notification;
import com.social.notification.service.contracts.NotificationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/user/notifications")
    public List<Notification> findUserNotifications(@RequestParam("userIdentity") String userIdentity) {
        return notificationService.findUserNotifications(userIdentity);
    }

    @GetMapping("/health")
    public String health() {
        return "Notification service is HEALTHY";
    }
}
