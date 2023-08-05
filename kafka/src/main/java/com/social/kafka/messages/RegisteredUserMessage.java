package com.social.kafka.messages;

import com.social.kafka.messages.contract.KafkaMessage;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public final class RegisteredUserMessage implements KafkaMessage {

    private final String identity;

    private final String email;

    private final String password;

}
