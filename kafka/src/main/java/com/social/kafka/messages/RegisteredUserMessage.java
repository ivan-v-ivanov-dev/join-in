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
public final class RegisteredUserMessage implements KafkaMessage {

    private final String identity;

    private final String email;

    private final String password;

}
