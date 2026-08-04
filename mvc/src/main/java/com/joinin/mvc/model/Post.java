package com.joinin.mvc.model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Post {
    private String authorProfileImage;
    private String authorNames;

    private String postIdentity;
    private String authorIdentity;
    private String groupIdentity;
    private String content;

    private boolean hasText;
    private boolean hasImage;
    private boolean hasVideo;
    private boolean poll;

    private String image;
    private String youtubeUrl;
    private String pollQuestion;

    private List<PollOption> pollOptions;
    private String postedAgo;

    private int likeCount;
    private int dislikeCount;
    private int hahaCount;
    private int angryCount;

    private List<Comment> comments;
}
