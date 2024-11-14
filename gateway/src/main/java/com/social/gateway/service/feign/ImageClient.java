package com.social.gateway.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "${image.service.feign.client.name}", url = "${image.service.url}")
public interface ImageClient {

    @GetMapping("${image.profile}")
    String findProfileImage(@PathVariable("identity") String userIdentity);

    @GetMapping("${image.background}")
    String findProfileBackgroundImage(@PathVariable String identity);

    @GetMapping("${image.albums}")
    List<String> findProfileAlbumImages(@PathVariable String identity);
}
