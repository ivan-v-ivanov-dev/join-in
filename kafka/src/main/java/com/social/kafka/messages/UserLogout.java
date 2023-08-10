package com.social.kafka.messages;

import com.social.kafka.messages.contract.KafkaMessage;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserLogout implements KafkaMessage {

    private final String identity;
}
