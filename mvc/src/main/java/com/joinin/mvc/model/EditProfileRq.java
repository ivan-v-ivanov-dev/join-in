package com.joinin.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EditProfileRq {

    private String firstName;

    private String lastName;

    private String aboutMe;

    private String mobile;

    private String address;

    private String birthDate;

    private String birthYear;

    private String birthplace;

    private String livesIn;

    private String gender;

    private String interestedIn;

    private String language;

    private String joined;

    private String status;

    private String phoneNumber;

    private String website;

    private String socialLink;

    private String hobbies;

    private String work;

    private String professionalSkills;

    private String college;

    private String currentCity;

    private String hometown;

    private String otherPlacesLived;

    private String password;

    private String confirmPassword;

    private MultipartFile profileImage;

    private MultipartFile backgroundImage;
}
