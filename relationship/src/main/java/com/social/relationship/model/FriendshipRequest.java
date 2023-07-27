package com.social.relationship.model;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class FriendshipRequest implements Serializable {

    private String profileIdentity;

    private String profileImage;

    private int friendsCount;
}
