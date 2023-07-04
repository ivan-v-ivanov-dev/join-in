package com.social.post.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Comment implements Serializable {

    private String authorIdentity;

    private String commentIdentity;

    private String content;

    private LocalDate postDate;
}
