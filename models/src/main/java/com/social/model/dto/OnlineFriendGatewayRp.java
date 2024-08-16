package com.social.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class OnlineFriendGatewayRp {

    private String identity;

    private String profileImage;

    private String names;
}
