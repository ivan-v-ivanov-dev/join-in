package com.social.message.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Transient;

@AllArgsConstructor
@Getter
public class User {

    private String identity;

    private boolean online;

    @Transient
    private String profileImage;
}