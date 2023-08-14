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
public final class PostMessage implements KafkaMessage {

    private final String userIdentity;

    private final String userNames;

    private final String content;

    private final String postDate;

}
