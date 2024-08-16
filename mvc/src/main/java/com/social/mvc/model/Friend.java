package com.social.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class Friend {

    private String profileIdentity;

    private String profileImage;

    private String firstName;

    private String lastName;
}
