package com.social.profile.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Notification {

    private String authorProfileImage;

    private String postIdentity;

    private String notification;

    private String postedAgo;

}
