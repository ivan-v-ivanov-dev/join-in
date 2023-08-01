package com.social.post.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Post implements Serializable {

    @Id
    @JsonIgnore
    private String id;

    @Indexed(unique = true)
    private String postIdentity;

    private String authorIdentity;

    @Transient
    private String authorProfileImage;

    private String content;

    private List<Comment> comments;

    @JsonIgnore
    private LocalDate postDate;

    @Transient
    private String postedAgo;

    @Transient
    private int likes;

    @Transient
    private Set<String> peopleIdentitiesWhoLikedThePost;

    @Transient
    private int dislikes;

    @Transient
    private int stars;

}
