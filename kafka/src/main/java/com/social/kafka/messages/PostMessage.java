package com.social.kafka.messages;

import com.social.kafka.messages.contract.KafkaMessage;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public final class PostMessage implements KafkaMessage {

    private final String userIdentity;

    private final String userNames;

    private final String content;

    private final String postDate;

}
