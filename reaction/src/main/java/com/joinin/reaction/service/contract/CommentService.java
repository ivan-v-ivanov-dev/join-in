package com.joinin.reaction.service.contract;

import com.join_in.common_models.CommentReactionsCountRpReactionService;

import java.util.List;

public interface CommentService {
    List<CommentReactionsCountRpReactionService> retrieveCommentsReactionsCount(List<String> identities);
}
