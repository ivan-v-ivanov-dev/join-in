package com.social.post.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Comment implements Serializable {

    @Id
    private String id;

    @Indexed(unique = true)
    private String commentIdentity;

    private String authorIdentity;

    private String content;

    private LocalDate postDate;
}
