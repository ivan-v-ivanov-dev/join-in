package com.social.profile.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${relationship.service.feign.client.name}", url = "${relationship.service.url}")
public interface RelationshipClient {

    @PostMapping("${relationship.find.friends.count}")
    int findFriendCountByProfileIdentity(@RequestParam("identity") String identity);
}
