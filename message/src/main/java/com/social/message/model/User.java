package com.social.message.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Transient;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    private String identity;

    private boolean online;

    @Transient
    private String profileImage;
}
