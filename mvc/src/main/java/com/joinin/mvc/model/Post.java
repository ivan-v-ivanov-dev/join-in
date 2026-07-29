package com.joinin.mvc.model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Post {
    private String postIdentity;
    private String authorIdentity;
    private String groupIdentity;
    private String content;

    private boolean hasText;
    private boolean hasImage;
    private boolean hasVideo;
    private boolean poll;

    private String imageIdentity;
    private String youtubeUrl;
    private String pollQuestion;

    private List<PollOption> pollOptions;
    private String postedAgo;
    private List<Comment> comments;
}
