package com.joinin.reaction.controller;

import com.join_in.common_models.PostReactionsCountRpReactionService;
import com.joinin.reaction.service.contract.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ReactionController {

    private final PostService postService;

    @PostMapping("/posts/reactions-count")
    public List<PostReactionsCountRpReactionService> retrievePostReactionsCount(@RequestBody List<String> identities) {
        return postService.retrievePostReactionsCount(identities);
    }
}
