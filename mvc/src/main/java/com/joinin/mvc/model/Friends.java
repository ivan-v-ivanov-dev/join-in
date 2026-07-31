package com.joinin.mvc.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Friends {

    private String identity;
    private String firstName;
    private String lastName;
    private String profileImage;
    private String onlineStatus;
}
