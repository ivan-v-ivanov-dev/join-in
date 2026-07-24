package com.joinin.gateway.service.feign;

import com.join_in.common_models.ProfileRpProfileService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "${profile.service.feign.client.name}", url = "${profile.service.url}")
public interface ProfileServiceClient {

    @GetMapping("/profile/{identity}")
    ProfileRpProfileService retrieveProfileByIdentity(@PathVariable String identity);
}
