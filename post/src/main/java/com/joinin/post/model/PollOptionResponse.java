package com.joinin.post.model;

public record PollOptionResponse(
        String optionIdentity,
        String optionText,
        int voteCount
) {
}
