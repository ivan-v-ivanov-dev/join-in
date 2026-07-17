package com.joinin.media.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

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
    private String profilePictureUrl;
    private String backgroundPictureUrl;
    @Builder.Default
    private List<String> albumPictureUrls = new ArrayList<>();
}
