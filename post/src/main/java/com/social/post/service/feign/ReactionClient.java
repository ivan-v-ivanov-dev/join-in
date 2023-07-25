package com.social.post.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@FeignClient(name = "${reaction.service.feign.client.name}", url = "${reaction.service.url}")
public interface ReactionClient {

    @PostMapping("${reaction.post.reactions.users.identities}")
    Set<String> findPeopleWhoReactedToPost(@RequestParam("postIdentity") String postIdentity);
}
