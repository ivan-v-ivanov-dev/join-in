package com.joinin.notification.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Builder
@ToString
public class Notification {
    private String authorIdentity;
    private String postIdentity;
    private String content;
    private boolean seen;
    private LocalDateTime createdAt;
}
