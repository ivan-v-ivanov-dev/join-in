package com.social.gateway.service.feign;

import com.social.model.dto.ProfileRp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "${profile.service.feign.client.name}", url = "${profile.service.url}")
public interface ProfileClient {

    @GetMapping("${profile.identity.endpoint}")
    ProfileRp findByIdentity(@PathVariable("identity") String identity);
}
