package com.social.kafka.messages;

import com.social.kafka.messages.contract.KafkaMessage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(force = true)
@AllArgsConstructor
@Getter
@Builder(toBuilder = true)
public final class CommentReactionMessage implements KafkaMessage {

    private final String reactingUserIdentity;

    private final String commentIdentity;

    private final String postIdentity;

    private final String commentAuthorIdentity;

    private final String commentAuthorNames;
}