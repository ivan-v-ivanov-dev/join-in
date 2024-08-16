package com.social.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class OnlineFriend {

    private String identity;

    private String profileImage;

    private String names;
}
