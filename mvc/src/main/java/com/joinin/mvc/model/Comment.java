package com.joinin.mvc.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Comment {

    private String commentIdentity;
    private String postIdentity;
    private String authorIdentity;
    private String content;
    private String postedAgo;
}
