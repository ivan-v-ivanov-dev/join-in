package com.social.profile.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostDto implements Serializable {

    private String id;

    private String authorIdentity;

    @Transient
    private String author;

    @Transient
    private String authorPhoto;

    private String postIdentity;

    private String content;

    private LocalDate postDate;

    @Transient
    private String postedAgo;
}
