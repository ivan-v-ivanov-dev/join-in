package com.social.post.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${image.service.feign.client.name}", url = "${image.service.url}")
public interface ImageClient {

    @PostMapping("${image.profile}")
    String findProfileImage(@RequestParam("userIdentity") String userIdentity);
}
