package com.social.login.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${profile.service.feign.client.name}", url = "${profile.service.url}")
public interface ProfileClient {

    @PostMapping("${profile.endpoint}")
    String profile(@RequestParam("identity") String identity);
}
