package com.social.gateway.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${authentication.service.feign.client.name}", url = "${authentication.service.url}")
public interface AuthenticationClient {

    @PostMapping("${authentication.login.endpoint}")
    String login(@RequestParam("email") String email, @RequestParam("password") String password);

    @PostMapping("${authentication.register.endpoint}")
    void register(@RequestParam("email") String email, @RequestParam("password") String password);
}
