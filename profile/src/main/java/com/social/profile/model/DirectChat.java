package com.social.profile.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class DirectChat {

    private String chatIdentity;

    private List<DirectChatMessage> directChatMessages;
}
