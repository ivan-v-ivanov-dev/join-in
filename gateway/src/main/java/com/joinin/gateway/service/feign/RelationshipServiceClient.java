package com.joinin.gateway.service.feign;

import com.join_in.common_models.FamilyMemberRpRelationshipService;
import com.join_in.common_models.ProfileRpRelationshipService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "${relationship.service.feign.client.name}", url = "${relationship.service.url}")
public interface RelationshipServiceClient {

    @GetMapping("/profile/{identity}/friends")
    List<ProfileRpRelationshipService> retrieveFriendsProfiles(@PathVariable String identity);

    @GetMapping("/profile/{identity}/frienship/requests")
    List<ProfileRpRelationshipService> retrieveFriendshipRequests(@PathVariable String identity);

    @GetMapping("/profile/{identity}/friends/count")
    int retrieveProfilesFriendsCount(@PathVariable String identity);

    @GetMapping("/profile/{identity}/family/members")
    List<FamilyMemberRpRelationshipService> retrieveProfileFamilyMembers(@PathVariable String identity);

    @GetMapping("/profile/{identity}/friend/suggestions")
    List<ProfileRpRelationshipService> retrieveFriendSuggestions(@PathVariable String identity);
}
