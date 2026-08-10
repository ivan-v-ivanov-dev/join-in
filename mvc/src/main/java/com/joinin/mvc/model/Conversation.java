package com.joinin.mvc.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Conversation {
    private String profileIdentity;
    private String participantNames;
    private String participantProfileImage;
    private String postedAgo;
    private String conversationIdentity;
    private String participantIdentity;
}
