package com.joinin.reaction.model;

public record CommentReactionsCount(
        String identity,
        int likeCount,
        int dislikeCount
) {
}
