package com.social.kafka.messages;

import com.social.kafka.messages.contract.KafkaMessage;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class NewPostNotificationMessage implements KafkaMessage {

    private List<String> friends;

    private String authorIdentity;

    private String authorNames;

    private String postIdentity;

    private String date;
}