package com.social.profile.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class FriendsDto {

    private String profileImage;

    private String firstName;

    private String lastName;
}
