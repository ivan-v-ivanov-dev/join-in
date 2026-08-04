package com.joinin.post.service.feign;

import com.join_in.common_models.ProfileImageRpMediaService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "${media.service.feign.client.name}", url = "${media.service.url}")
public interface MediaServiceClient {

    @PostMapping(value = "/profiles/profile-images", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ProfileImageRpMediaService> retrieveProfileImagesForProfiles(@RequestBody List<String> identities);

    @GetMapping("/post/{identity}/image")
    String retrievePostImage(@PathVariable("identity") String identity);
}
