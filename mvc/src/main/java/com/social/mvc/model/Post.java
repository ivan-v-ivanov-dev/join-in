package com.social.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Builder
@Getter
public class Post {

    private String authorIdentity;

    private String authorNames;

    private String authorProfileImage;

    private String postIdentity;

    private String content;

    List<Comment> comments;

    private String postedAgo;

    private int likes;

    private Set<String> peopleIdentitiesWhoLikedThePost;

    private List<String> peopleNamesWhoLikedThePost;

    private int dislikes;

    private Set<String> peopleIdentitiesWhoDislikedThePost;

    private List<String> peopleNamesWhoDislikedThePost;

    private int stars;

    private Set<String> peopleIdentitiesWhoStaredThePost;

    private List<String> peopleNamesWhoStaredThePost;
}
