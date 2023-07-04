package com.social.post.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "posts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Post {

    @Id
    private String id;

    @Indexed
    private String authorIdentity;

    @Indexed(unique = true)
    private String postIdentity;

    private String content;

    private LocalDate postDate;

}
