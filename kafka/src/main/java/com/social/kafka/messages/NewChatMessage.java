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
public final class NewChatMessage implements KafkaMessage {

    private final String messageContent;

    private final String chatIdentity;

    private final String senderIdentity;

    private final String date;
}
