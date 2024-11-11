package com.social.mvc.service.feign;

import com.social.model.dto.ProfileGatewayRp;
import com.social.model.dto.RegisterUserRq;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${gateway.service.feign.client.name}", url = "${gateway.service.url}")
public interface GatewayClient {

    @PostMapping("${gateway.login.endpoint}")
    String login(@RequestParam("email") String email, @RequestParam("password") String password);

    @PostMapping("${gateway.logout.endpoint}")
    String logout(@RequestParam("userIdentity") String userIdentity);

    @PostMapping("${gateway.register.endpoint}")
    void register(@RequestBody RegisterUserRq registerUserRq);

    @PostMapping("${gateway.profile.endpoint}")
    ProfileGatewayRp findProfileInfoByIdentity(@PathVariable("identity") String identity);
}
