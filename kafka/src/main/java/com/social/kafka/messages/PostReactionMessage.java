package com.social.kafka.messages;

import com.social.kafka.messages.contract.KafkaMessage;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public final class PostReactionMessage implements KafkaMessage {

    private final String reactingUserIdentity;

    private final String postIdentity;

    private final String postAuthorIdentity;

    private final String postAuthorNames;
}
