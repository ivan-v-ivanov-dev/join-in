package com.social.profile.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Post implements Serializable {

    @JsonIgnore
    private String id;

    private String authorIdentity;

    private String authorNames;

    private String authorProfileImage;

    private String postIdentity;

    private String content;

    List<Comment> comments;

    private LocalDate postDate;

    private String postedAgo;

    private int likes;

    private Set<String> peopleIdentitiesWhoLikedThePost;

    private List<String> peopleNamesWhoLikedThePost;

    private int dislikes;

    private Set<String> peopleIdentitiesWhoDislikedThePost;

    private List<String> peopleNamesWhoDislikedThePost;

    private int stars;
}
