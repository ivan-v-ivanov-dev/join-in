package com.social.kafka.messages;

import com.social.kafka.messages.contract.KafkaMessage;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class FriendshipMessage implements KafkaMessage {

    private String recipientUserIdentity;

    private String senderUserIdentity;

}
