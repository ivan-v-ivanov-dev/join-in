package com.social.profile.service.feign;

import com.social.profile.model.Friend;
import com.social.profile.model.FriendSuggestion;
import com.social.profile.model.FriendshipRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "${relationship.service.feign.client.name}", url = "${relationship.service.url}")
public interface RelationshipClient {

    @PostMapping("${relationship.find.friends.for.user}")
    List<Friend> findFriends(@RequestParam("identity") String identity);

    @PostMapping("${relationship.find.friends.count}")
    int findFriendCount(@RequestParam("identity") String identity);

    @PostMapping("${relationship.find.friendship.requests.for.user}")
    List<FriendshipRequest> findFriendshipRequests(@RequestParam("identity") String identity);

    @PostMapping("${relationship.find.friendship.requests.count}")
    int findFriendshipRequestsCount(@RequestParam("identity") String identity);

    @PostMapping("${relationship.find.friend.suggestions}")
    List<FriendSuggestion> findFriendSuggestions(@RequestParam("identity") String identity);
}
