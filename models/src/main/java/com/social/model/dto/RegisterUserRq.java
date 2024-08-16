package com.social.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class RegisterUserRq {

    private String firstName;

    private String lastName;

    private String email;

    private String password;
}
