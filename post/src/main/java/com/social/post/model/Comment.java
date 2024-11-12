package com.social.post.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Comment implements Serializable {

    @Id
    @JsonIgnore
    private String id;

    @Indexed(unique = true)
    private String commentIdentity;

    private String authorIdentity;

    private String content;

    @JsonIgnore
    private LocalDate postDate;

    @Transient
    private String postedAgo;

}
