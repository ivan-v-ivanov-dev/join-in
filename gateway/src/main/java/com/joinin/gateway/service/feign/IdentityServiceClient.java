package com.joinin.gateway.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "${identity.service.feign.client.name}", url = "${identity.service.url}")
public interface IdentityServiceClient {

    @PostMapping("/email/{email}/unique")
    boolean isEmailUnique(@PathVariable("email") String email);
}
