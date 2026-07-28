package com.joinin.post.model;

import java.time.LocalDateTime;

public record CommentResponse(
        String commentIdentity,
        String postIdentity,
        String authorIdentity,
        String content,
        LocalDateTime createdAt
) {
}
