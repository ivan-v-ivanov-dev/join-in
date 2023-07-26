package com.social.post.model;

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
    private String id;

    @Indexed(unique = true)
    private String commentIdentity;

    private String authorIdentity;

    @Transient
    private String authorProfileImage;

    private String content;

    private LocalDate postDate;
}
