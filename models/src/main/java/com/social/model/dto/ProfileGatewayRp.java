package com.social.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Builder
@Getter
public class ProfileGatewayRp {

    private String identity;

    private String firstName;

    private String lastName;

    private String email;

    private String aboutMe;

    private String mobile;

    private String city;

    private String country;

    private LocalDate birthDate;

    private String gender;

    private LocalDate joined;

    private String status;

    private String website;

    private String hobbies;

}
