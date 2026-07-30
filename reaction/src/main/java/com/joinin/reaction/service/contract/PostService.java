package com.joinin.reaction.service.contract;

import com.join_in.common_models.PostReactionsCountRpReactionService;

import java.util.List;

public interface PostService {
    List<PostReactionsCountRpReactionService> retrievePostReactionsCount(List<String> identities);
}
