package com.joinin.mvc.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Comment {
    private String authorProfileImage;
    private String authorNames;

    private String commentIdentity;
    private String postIdentity;
    private String authorIdentity;
    private String content;

    private int likeCount;
    private int dislikeCount;

    private String postedAgo;
}
