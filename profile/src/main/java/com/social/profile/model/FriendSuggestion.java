package com.social.profile.model;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class FriendSuggestion implements Serializable {

    private String profileIdentity;

    private String profileImage;

    private String names;
}
