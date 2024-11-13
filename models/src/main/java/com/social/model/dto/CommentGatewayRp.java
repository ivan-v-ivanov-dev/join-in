package com.social.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class CommentGatewayRp {

    private String commentIdentity;

    private String authorIdentity;

    private String authorProfileImage;

    private String authorNames;

    private String content;

    private String postedAgo;

    private int likes;

    private int dislikes;
}
