package com.social.kafka.messages;

import com.social.kafka.messages.contract.KafkaMessage;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PostReactionMessage implements KafkaMessage {

    private String userIdentity;

    private String postIdentity;
}
