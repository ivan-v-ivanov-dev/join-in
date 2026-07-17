package com.joinin.profile.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Getter
@Builder
@ToString
@Document(collection = "profiles")
public class Profile {

    @Id
    private String id;
    @Indexed(unique = true)
    private String identity;

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
}
