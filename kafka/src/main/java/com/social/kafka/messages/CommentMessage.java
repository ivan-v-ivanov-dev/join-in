package com.social.kafka.messages;

import com.social.kafka.messages.contract.KafkaMessage;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CommentMessage implements KafkaMessage {

    private String postIdentity;

    private String userIdentity;

    private String content;

}
