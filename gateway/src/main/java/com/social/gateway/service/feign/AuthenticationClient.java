package com.social.gateway.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${login.service.feign.client.name}", url = "${login.service.url}")
public interface AuthenticationClient {

    @PostMapping("${login.endpoint}")
    String login(@RequestParam("email") String email, @RequestParam("password") String password);
}
