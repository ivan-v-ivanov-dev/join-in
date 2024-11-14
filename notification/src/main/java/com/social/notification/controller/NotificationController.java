package com.social.notification.controller;

import com.social.model.dto.NotificationRp;
import com.social.notification.service.contract.NotificationService;
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
    public List<NotificationRp> findProfileNotifications(@PathVariable("identity") String identity) {
        return notificationService.findProfileNotifications(identity);
    }

    @GetMapping("/health")
    public String health() {
        return "Notification service is HEALTHY";
    }
}
