package com.social.relationship.model;

import lombok.*;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Friend implements Serializable {

    private String profileIdentity;

    private String profileImage;

}
