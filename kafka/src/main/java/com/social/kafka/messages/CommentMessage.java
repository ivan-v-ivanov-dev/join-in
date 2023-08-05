package com.social.kafka.messages;

import com.social.kafka.messages.contract.KafkaMessage;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public final class CommentMessage implements KafkaMessage {

    private final String postIdentity;

    private final String postAuthorIdentity;

    private final String commentAuthorIdentity;

    private final String commentAuthorNames;

    private final String content;

    private final String postDate;
}
