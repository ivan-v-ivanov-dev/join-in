package com.joinin.gateway.service;

import com.joinin.gateway.service.contract.ReactionService;
import com.joinin.gateway.service.feign.ReactionServiceClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class ReactionServiceImpl implements ReactionService {

    private final ReactionServiceClient reactionServiceClient;

    @Override
    public int retrievePostsAndCommentsReactionsCount(String identity) {
        int postsReactionCount = reactionServiceClient.retrievePostsReactionsCount(identity);
        log.info("Retrieve posts reactions count: " + postsReactionCount);
        int commentsReactionCount = reactionServiceClient.retrieveCommentsReactionsCount(identity);
        log.info("Retrieve comments reactions count: " + commentsReactionCount);
        return postsReactionCount + commentsReactionCount;
    }
}
