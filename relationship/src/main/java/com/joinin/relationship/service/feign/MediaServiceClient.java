package com.joinin.relationship.service.feign;

import com.join_in.common_models.ProfileImageRpMediaService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "${media.service.feign.client.name}", url = "${media.service.url}")
public interface MediaServiceClient {

    @GetMapping(value = "/profiles/profile-images", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ProfileImageRpMediaService> retrieveProfileImagesForProfiles(@RequestParam List<String> identities);
}
