package com.joinin.reaction.controller;

import com.join_in.common_models.CommentReactionsCountRpReactionService;
import com.join_in.common_models.PostReactionsCountRpReactionService;
import com.joinin.reaction.service.contract.CommentService;
import com.joinin.reaction.service.contract.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ReactionController {

    private final PostService postService;
    private final CommentService commentService;

    @PostMapping("/posts/reactions-count")
    public List<PostReactionsCountRpReactionService> retrievePostReactionsCount(@RequestBody List<String> identities) {
        return postService.retrievePostReactionsCount(identities);
    }

    @PostMapping("/comments/reactions-count")
    public List<CommentReactionsCountRpReactionService> retrieveCommentsReactionsCount(@RequestBody List<String> identities) {
        return commentService.retrieveCommentsReactionsCount(identities);
    }

    @GetMapping("/profile/{identity}/posts/reactions/count")
    public int retrievePostsReactionsCount(@PathVariable String identity) {
        return postService.retrievePostsReactionsCountByProfileIdentity(identity);
    }

    @GetMapping("/profile/{identity}/comments/reactions/count")
    public int retrieveCommentsReactionsCount(@PathVariable String identity) {
        return commentService.retrieveCommentsReactionsCountByProfileIdentity(identity);
    }
}
