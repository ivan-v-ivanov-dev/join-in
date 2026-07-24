package com.joinin.gateway.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "${media.service.feign.client.name}", url = "${media.service.url}")
public interface MediaServiceClient {

    @GetMapping(value = "/profile/{identity}/profile-image", produces = "image/webp")
    String retrieveProfileImage(@PathVariable String identity);

    @GetMapping(value = "/profile/{identity}/background-image", produces = "image/webp")
    String retrieveProfileBackgroundImage(@PathVariable String identity);

    @GetMapping(value = "/profile/{identity}/album-images", produces = MediaType.APPLICATION_JSON_VALUE)
    List<String> getProfileAlbumImages(@PathVariable String identity);
}
