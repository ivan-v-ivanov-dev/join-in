package com.joinin.gateway.service.feign;

import com.join_in.common_models.NotificationRpNotificationService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "${notification.service.feign.client.name}", url = "${notification.service.url}")
public interface NotificationServiceClient {

    @GetMapping("/profile/{identity}")
    List<NotificationRpNotificationService> retrieveProfileNotifications(@PathVariable("identity") String identity);
}
