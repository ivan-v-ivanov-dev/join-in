package com.social.relationship.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class FriendSuggestion {

    private String profileIdentity;

    private String profileImage;
}
