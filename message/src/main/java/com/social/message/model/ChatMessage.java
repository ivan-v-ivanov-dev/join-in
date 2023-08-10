package com.social.message.model;

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
public class ChatMessage {

    private String senderIdentity;

    @Transient
    private String senderProfileImage;

    private String receiverIdentity;

    @Transient
    private String receiverProfileImage;

    private String content;

    private LocalDate date;

    @Transient
    private String postedAgo;
}
