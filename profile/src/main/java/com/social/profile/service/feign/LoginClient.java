package com.social.profile.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${login.service.feign.client.name}", url = "${login.service.url}")
public interface LoginClient {

    @PostMapping("${login.endpoint}")
    String authenticate(@RequestParam("email") String email,
                        @RequestParam("password") String password);
}
