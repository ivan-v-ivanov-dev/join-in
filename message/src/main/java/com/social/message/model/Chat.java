package com.social.message.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class Chat {

    private String chatIdentity;

    private List<ChatMessage> chatMessages;
}
