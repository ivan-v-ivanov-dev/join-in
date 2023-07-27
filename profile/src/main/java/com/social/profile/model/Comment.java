package com.social.profile.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Comment {

    private String commentIdentity;

    private String authorIdentity;

    private String authorProfileImage;

    private String authorNames;

    private String content;

    private String postedAgo;

    private int likes;

    private int dislikes;
}
