package com.joinin.mvc.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Notification {
    private String authorIdentity;
    private String authorProfileImage;
    private String postIdentity;
    private String content;
    private String postedAgo;
}
