package com.social.profile.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "profiles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Profile {

    @Id
    private String id;

    @Indexed(unique = true)
    @JsonIgnore
    private String identity;

    private String firstName;

    private String lastName;

    @Indexed(unique = true)
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
