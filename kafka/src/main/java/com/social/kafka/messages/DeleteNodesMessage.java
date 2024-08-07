package com.social.kafka.messages;

import com.social.kafka.messages.contract.KafkaMessage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor(force = true)
@AllArgsConstructor
@Getter
@Builder(toBuilder = true)
public final class DeleteNodesMessage implements KafkaMessage {

    private final Set<String> commentsNodesIdentities;

    private final String postIdentity;
}
