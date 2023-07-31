package com.social.kafka.messages;

import com.social.kafka.messages.contract.KafkaMessage;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CommentReactionMessage implements KafkaMessage {

    private String reactingUserIdentity;

    private String commentIdentity;

    private String postIdentity;

    private String commentAuthorIdentity;

    private String commentAuthorNames;
}
