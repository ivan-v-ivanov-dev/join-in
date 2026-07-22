package com.joinin.identity.model;

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
    private final String identity;
    private final String email;
    private final String password;
}
