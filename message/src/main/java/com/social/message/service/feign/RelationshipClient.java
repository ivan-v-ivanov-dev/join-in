package com.social.message.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@FeignClient(name = "${relationship.service.feign.client.name}", url = "${relationship.service.url}")
public interface RelationshipClient {

    @PostMapping("${relationship.find.profile.friends.identities}")
    Set<String> findFriendsIdentities(@RequestParam("identity") String identity);
}
