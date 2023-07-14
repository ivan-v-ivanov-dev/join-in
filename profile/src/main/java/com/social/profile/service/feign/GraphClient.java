package com.social.profile.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${graph.service.feign.client.name}", url = "${graph.service.url}")
public interface GraphClient {

    @PostMapping("${graph.find.likes.count}")
    int findLikesAPostProfileCount(@RequestParam("postIdentity") String postIdentity);

    @PostMapping("${graph.find.dislikes.count}")
    int findDislikesAPostProfileCount(@RequestParam("postIdentity") String postIdentity);

    @PostMapping("${graph.find.stars.count}")
    int findStarsAPostProfileCount(@RequestParam("postIdentity") String postIdentity);
}
