package com.social.post.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Post implements Serializable {

    @Id
    @JsonIgnore
    private String id;

    @Indexed(unique = true)
    private String postIdentity;

    private String authorIdentity;

    private String content;

    private List<Comment> comments;

    private LocalDate postDate;

}
