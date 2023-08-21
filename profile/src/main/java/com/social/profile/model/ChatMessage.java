package com.social.profile.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChatMessage {

    private String senderIdentity;

    private String senderProfileImage;

    private String content;

    private LocalDate date;

    private String postedAgo;
}
