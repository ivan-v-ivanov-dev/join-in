package com.social.profile.service.feign;

import com.social.profile.model.Notification;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "${notification.service.feign.client.name}", url = "${notification.service.url}")
public interface NotificationClient {

    @PostMapping("${user.notifications}")
    List<Notification> findUserNotifications(@RequestParam("userIdentity") String userIdentity);
}
