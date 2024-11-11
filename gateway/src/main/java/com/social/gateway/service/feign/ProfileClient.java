package com.social.gateway.service.feign;

import com.social.model.dto.ProfileRp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "${profile.service.feign.client.name}", url = "${profile.service.url}")
public interface ProfileClient {

    @PostMapping("${profile.identity.endpoint}")
    ProfileRp findByIdentity(@PathVariable("identity") String identity);
}
