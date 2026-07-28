package com.joinin.post.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

public record PostResponse(

        String postIdentity,
        String authorIdentity,
        String groupIdentity,

        String content,

        boolean hasText,
        boolean hasImage,
        boolean hasVideo,

        @JsonProperty("isPoll")
        boolean poll,

        String imageIdentity,
        String youtubeUrl,

        String pollQuestion,
        List<PollOptionResponse> pollOptions,

        LocalDateTime createdAt,
        List<CommentResponse> comments) {
}
