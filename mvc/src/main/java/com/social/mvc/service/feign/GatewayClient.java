package com.social.mvc.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${gateway.service.feign.client.name}", url = "${gateway.service.url}")
public interface GatewayClient {

    @PostMapping("&{gateway.login.endpoint}")
    String login(@RequestParam("email") String email, @RequestParam("password") String password);
}
