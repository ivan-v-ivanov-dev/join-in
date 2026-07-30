package com.joinin.reaction.model;

public record PostReactionsCount(
        String identity,
        int likeCount,
        int dislikeCount,
        int hahaCount,
        int angryCount
) {
}
