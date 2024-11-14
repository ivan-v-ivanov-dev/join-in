package com.social.gateway.service.feign;

import com.social.model.dto.NotificationRp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "${notification.service.feign.client.name}", url = "${notification.service.url}")
public interface NotificationClient {

    @GetMapping("${notification.find.profile.notifications}")
    List<NotificationRp> findProfileNotifications(@PathVariable("identity") String identity);
}
