package com.social.profile.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${reaction.service.feign.client.name}", url = "${reactionv.service.url}")
public interface ReactionClient {

    @PostMapping("${reaction.find.likes.count}")
    int findLikesAPostProfileCount(@RequestParam("postIdentity") String postIdentity);

    @PostMapping("${reaction.find.dislikes.count}")
    int findDislikesAPostProfileCount(@RequestParam("postIdentity") String postIdentity);

    @PostMapping("${reaction.find.stars.count}")
    int findStarsAPostProfileCount(@RequestParam("postIdentity") String postIdentity);
}
