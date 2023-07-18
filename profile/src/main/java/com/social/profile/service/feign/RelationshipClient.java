package com.social.profile.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "${relationship.service.feign.client.name}", url = "${relationship.service.url}")
public interface RelationshipClient {

    @PostMapping("${relationship.find.friends.for.user}")
    List<String> findFriends(@RequestParam("identity") String identity);

    @PostMapping("${relationship.find.friends.count}")
    int findFriendCount(@RequestParam("identity") String identity);
}
