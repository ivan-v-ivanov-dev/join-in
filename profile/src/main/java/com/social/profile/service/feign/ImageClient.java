package com.social.profile.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "${image.service.feign.client.name}", url = "${image.service.url}")
public interface ImageClient {

    @PostMapping("${image.profile}")
    String findProfileImage(@RequestParam("userIdentity") String userIdentity);

    @PostMapping("${image.background}")
    String findProfileBackgroundImage(@RequestParam("userIdentity") String userIdentity);

    @PostMapping("${album.images}")
    List<String> findProfileAlbumImage(@RequestParam("userIdentity") String userIdentity);
}
