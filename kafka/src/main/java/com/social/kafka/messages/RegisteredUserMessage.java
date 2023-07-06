package com.social.kafka.messages;

import com.social.kafka.messages.contract.KafkaMessage;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RegisteredUserMessage implements KafkaMessage {

    private String identity;

    private String email;

    private String password;

}
