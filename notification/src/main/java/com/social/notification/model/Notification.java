package com.social.notification.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Notification {

    @Id
    private String id;

    private String authorIdentity;

    private String postIdentity;

    private String notification;

    private LocalDate date;

    private boolean seen;
}
