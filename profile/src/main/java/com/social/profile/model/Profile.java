package com.social.profile.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "profiles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Profile {

    @Id
    private String id;

    private String image;

    @Indexed(unique = true)
    @JsonIgnore
    private String identity;

    private String firstName;

    private String lastName;

    @Indexed(unique = true)
    private String email;

}
