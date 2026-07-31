package com.joinin.post.service.feign;

import com.join_in.common_models.CommentReactionsCountRpReactionService;
import com.join_in.common_models.PostReactionsCountRpReactionService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "${reaction.service.feign.client.name}", url = "${reaction.service.url}")
public interface ReactionServiceClient {

    @PostMapping("/posts/reactions-count")
    List<PostReactionsCountRpReactionService> retrievePostReactionsCount(@RequestBody List<String> identities);

    @PostMapping("/comments/reactions-count")
    List<CommentReactionsCountRpReactionService> retrieveCommentsReactionsCount(@RequestBody List<String> identities);
}
