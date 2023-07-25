package com.social.kafka.messages;

import com.social.kafka.messages.contract.KafkaMessage;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class NewPostCommentNotificationMessage implements KafkaMessage {

    private Set<String> peopleToNotify;

    private String authorIdentity;

    private String authorNames;

    private String postIdentity;

    private String date;
}
