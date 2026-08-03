package com.joinin.gateway.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "${reaction.service.feign.client.name}", url = "${reaction.service.url}")
public interface ReactionServiceClient {

    @GetMapping("/profile/{identity}/posts/reactions/count")
    int retrievePostsReactionsCount(@PathVariable String identity);

    @GetMapping("/profile/{identity}/comments/reactions/count")
    int retrieveCommentsReactionsCount(@PathVariable String identity);
}
