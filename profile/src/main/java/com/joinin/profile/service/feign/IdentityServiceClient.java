package com.joinin.profile.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "${identity.service.feign.client.name}", url = "${identity.service.url}")
public interface IdentityServiceClient {

    @GetMapping("/identity/{identity}/email")
    String retrieveEmailByIdentity(@PathVariable String identity);
}
