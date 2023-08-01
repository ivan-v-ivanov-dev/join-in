package com.social.notification.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Notification {

    @Id
    private String id;

    private String authorIdentity;

    @Transient
    private String authorProfileImage;

    private String postIdentity;

    private String notification;

    private LocalDate date;

    @Transient
    private String postedAgo;

    private boolean seen;
}
