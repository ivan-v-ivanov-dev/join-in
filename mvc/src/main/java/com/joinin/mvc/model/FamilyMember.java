package com.joinin.mvc.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class FamilyMember {
    private String identity;
    private String relationshipType;
    private String profileImage;
    private String firstName;
    private String lastName;
}
