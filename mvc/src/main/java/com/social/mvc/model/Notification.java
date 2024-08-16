package com.social.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class Notification {

    private String authorProfileImage;

    private String postIdentity;

    private String notification;

    private String postedAgo;
}
