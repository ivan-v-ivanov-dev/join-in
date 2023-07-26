package com.social.reaction.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@FeignClient(name = "${post.service.feign.client.name}", url = "${post.service.url}")
public interface PostClient {

    @PostMapping("${post.comments.authors}")
    Set<String> findAllUsersCommentingThePost(@RequestParam("postIdentity") String postIdentity,
                                              @RequestParam("authorIdentity") String authorIdentity);
}
