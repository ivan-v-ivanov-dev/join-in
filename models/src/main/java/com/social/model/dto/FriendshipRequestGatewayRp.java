package com.social.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class FriendshipRequestGatewayRp {

    private String profileIdentity;

    private String profileImage;

    private String firstName;

    private String lastName;

    private int friendCount;
}