package com.joinin.gateway.service.feign;

import com.join_in.common_models.ProfileRpRelationshipService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "${relationship.service.feign.client.name}", url = "${relationship.service.url}")
public interface RelationshipServiceClient {

    @GetMapping("/profile/{identity}/friends")
    List<ProfileRpRelationshipService> retrieveFriendsProfiles(@PathVariable String identity);
}
