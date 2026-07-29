package com.joinin.post.model;

public record CommentResponse(
        String commentIdentity,
        String postIdentity,
        String authorIdentity,
        String content,
        String postedAgo
) {
}
