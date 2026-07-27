package com.joinin.relationship.service.feign;

import com.join_in.common_models.ProfileRpProfileNamesProfileService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "${profile.service.feign.client.name}", url = "${profile.service.url}")
public interface ProfileServiceClient {

    @GetMapping("/profiles/names")
    List<ProfileRpProfileNamesProfileService> retrieveProfilesNames(@RequestParam List<String> identities);
}
