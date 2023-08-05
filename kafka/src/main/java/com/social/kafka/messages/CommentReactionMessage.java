package com.social.kafka.messages;

import com.social.kafka.messages.contract.KafkaMessage;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public final class CommentReactionMessage implements KafkaMessage {

    private final String reactingUserIdentity;

    private final String commentIdentity;

    private final String postIdentity;

    private final String commentAuthorIdentity;

    private final String commentAuthorNames;
}
