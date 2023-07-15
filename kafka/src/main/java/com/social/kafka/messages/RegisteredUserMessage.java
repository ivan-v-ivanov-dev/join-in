package com.social.kafka.messages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegisteredUserMessage extends NewUserMessage {

    private String email;

    private String password;

}
