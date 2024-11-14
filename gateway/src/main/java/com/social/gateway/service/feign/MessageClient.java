package com.social.gateway.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "${message.service.feign.client.name}", url = "${message.service.url}")
public interface MessageClient {

    @GetMapping("${message.service.friend.online.status}")
    boolean findUserOnlineStatus(@PathVariable("identity") String identity);
}
