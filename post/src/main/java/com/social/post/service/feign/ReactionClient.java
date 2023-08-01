package com.social.post.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@FeignClient(name = "${reaction.service.feign.client.name}", url = "${reaction.service.url}")
public interface ReactionClient {

    @PostMapping("${reaction.post.reactions.users.identities}")
    Set<String> findPeopleWhoReactedToPost(@RequestParam("postIdentity") String postIdentity);

    @PostMapping("${reaction.find.post.likes.count}")
    int findLikesAPostProfileCount(@RequestParam("postIdentity") String postIdentity);

    @PostMapping("/post/likes/users")
    Set<String> findPeopleWhoLikedThePost(@RequestParam("postIdentity") String postIdentity);

    @PostMapping("${reaction.find.comment.likes.count}")
    int findLikesACommentProfileCount(@RequestParam("commentIdentity") String commentIdentity);

    @PostMapping("${reaction.find.post.dislikes.count}")
    int findDislikesAPostProfileCount(@RequestParam("postIdentity") String postIdentity);

    @PostMapping("/post/dislikes/users")
    Set<String> findPeopleWhoDislikedThePost(@RequestParam("postIdentity") String postIdentity);

    @PostMapping("${reaction.find.comment.dislikes.count}")
    int findDislikesACommentProfileCount(@RequestParam("commentIdentity") String commentIdentity);

    @PostMapping("${reaction.find.post.stars.count}")
    int findStarsAPostProfileCount(@RequestParam("postIdentity") String postIdentity);
}
