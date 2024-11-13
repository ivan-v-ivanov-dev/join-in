package com.social.gateway.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

@FeignClient(name = "${reaction.service.feign.client.name}", url = "${reaction.service.url}")
public interface ReactionClient {

    @GetMapping("${reaction.find.post.likes.count}")
    int findPostLikesCount(@PathVariable("postIdentity") String postIdentity);

    @GetMapping("${reaction.find.post.dislikes.count}")
    int findPostDislikesCount(@PathVariable("postIdentity") String postIdentity);

    @GetMapping("${reaction.find.post.stars.count}")
    int findPostStarsCount(@PathVariable("postIdentity") String postIdentity);

    @GetMapping("${reaction.find.post.likes.user.identities}")
    Set<String> findProfileIdentitiesWhoLikedThePost(@PathVariable("postIdentity") String postIdentity);

    @GetMapping("${reaction.find.post.dislikes.user.identities}")
    Set<String> findProfileIdentitiesWhoDislikedThePost(@PathVariable("postIdentity") String postIdentity);

    @GetMapping("${reaction.find.post.stars.user.identities}")
    Set<String> findProfileIdentitiesWhoStaredThePost(@PathVariable("postIdentity") String postIdentity);
}
