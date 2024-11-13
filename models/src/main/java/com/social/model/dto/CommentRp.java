package com.social.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class CommentRp {

    private String commentIdentity;

    private String authorIdentity;

    private String authorNames;

    private String content;

    private String postedAgo;

}
