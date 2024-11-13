package com.social.gateway.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "${reaction.service.feign.client.name}", url = "${reaction.service.url}")
public interface ReactionClient {

    @GetMapping("${reaction.find.post.likes.count}")
    int findPostLikesCount(@PathVariable("postIdentity") String postIdentity);
}
