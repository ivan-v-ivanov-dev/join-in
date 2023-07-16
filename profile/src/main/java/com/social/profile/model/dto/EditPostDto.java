package com.social.profile.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Transient;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EditPostDto {

    @JsonIgnore
    private String id;

    @Transient
    private String author;

    @Transient
    private String authorPhoto;

    private String postIdentity;

    private String content;

    @JsonIgnore
    private LocalDate postDate;
}
