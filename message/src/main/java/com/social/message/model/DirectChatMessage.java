package com.social.message.model;

import lombok.*;
import org.springframework.data.annotation.Transient;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DirectChatMessage {

    private String senderIdentity;

    @Transient
    private String senderProfileImage;

    private String content;

    private LocalDate date;

    @Transient
    private String postedAgo;
}
