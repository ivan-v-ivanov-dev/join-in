package com.joinin.mvc.service.feign;

import com.join_in.common_models.RegisterUserMVCRq;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "${gateway.service.feign.client.name}", url = "${gateway.service.url}")
public interface GatewayClient {

    @GetMapping("/health")
    String health();

    @PostMapping("/email/{email}/unique")
    boolean isEmailUnique(@PathVariable("email") String email);

    @PostMapping("/register")
    void registerUser(@RequestBody RegisterUserMVCRq registerUserMVCRq);

}
