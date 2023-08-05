package com.social.kafka.messages;

import com.social.kafka.messages.contract.KafkaMessage;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public final class EditPostMessage implements KafkaMessage {

    private final String postIdentity;

    private final String auhthorIdentity;

    private final String newContent;
}
