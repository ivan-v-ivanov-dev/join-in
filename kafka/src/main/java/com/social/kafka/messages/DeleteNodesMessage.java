package com.social.kafka.messages;

import com.social.kafka.messages.contract.KafkaMessage;
import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Getter
@Builder
public final class DeleteNodesMessage implements KafkaMessage {

    private final Set<String> commentsNodesIdentities;

    private final String postIdentity;
}
