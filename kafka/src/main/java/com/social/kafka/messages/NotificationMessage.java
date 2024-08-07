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
public final class NotificationMessage implements KafkaMessage {

    private final Set<String> peopleToNotify;

    private final String authorIdentity;

    private final String authorNames;

    private final String postIdentity;

    private final String date;
}
