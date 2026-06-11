package com.social.profile.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "profiles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Profile {

    @Id
    private String id;

    @Indexed(unique = true)
//    @JsonIgnore
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

    public String getId() {
        return id;
    }

    public String getIdentity() {
        return identity;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public String getMobile() {
        return mobile;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getJoined() {
        return joined;
    }

    public String getStatus() {
        return status;
    }

    public String getWebsite() {
        return website;
    }

    public String getHobbies() {
        return hobbies;
    }
}
