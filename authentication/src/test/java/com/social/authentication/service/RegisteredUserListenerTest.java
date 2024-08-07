package com.social.authentication.service;

import com.social.authentication.model.User;
import com.social.authentication.service.contract.PasswordEncoder;
import com.social.authentication.service.contract.RegisterService;
import com.social.kafka.messages.RegisteredUserMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RegisteredUserListenerTest {

    @Mock
    PasswordEncoder passwordEncoder;
    @Mock
    RegisterService registerService;
    @InjectMocks
    RegisteredUserListener registeredUserListener;

    @Test
    public void listener_shouldCallService() {
        RegisteredUserMessage registeredUserMessage = RegisteredUserMessage.builder()
                .identity("identity")
                .email("mail@mail.com")
                .password("password")
                .build();
        when(passwordEncoder.encode(registeredUserMessage.getPassword())).thenReturn(registeredUserMessage.getPassword());

        registeredUserListener.listener(registeredUserMessage);

        verify(registerService).save(any(User.class));
    }
}
