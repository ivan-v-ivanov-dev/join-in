package com.social.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Builder
@Getter
public class PostRp {

    private String authorIdentity;

    private String authorNames;

    private String postIdentity;

    private String content;

    List<CommentRp> comments;

    private String postedAgo;

}
