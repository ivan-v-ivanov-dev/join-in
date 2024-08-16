package com.social.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class NotificationGatewayRp {

    private String authorProfileImage;

    private String postIdentity;

    private String notification;

    private String postedAgo;
}
