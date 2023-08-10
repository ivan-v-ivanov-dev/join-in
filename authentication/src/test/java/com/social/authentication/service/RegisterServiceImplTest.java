package com.social.authentication.service;

import com.social.authentication.model.User;
import com.social.authentication.repository.UserRepository;
import com.social.authentication.service.contract.KafkaMessageSender;
import com.social.kafka.messages.NewUserMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RegisterServiceImplTest {

    @Mock
    UserRepository userRepository;
    @Mock
    KafkaMessageSender kafkaMessageSender;
    @InjectMocks
    RegisterServiceImpl registerService;

    @Test
    public void save_shouldCallRepository() {
        User user = createUser();
        when(userRepository.save(user)).thenReturn(user);
        registerService.save(user);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void save_should_sendMessage() {
        User user = createUser();
        when(userRepository.save(user)).thenReturn(user);
        registerService.save(user);
        verify(kafkaMessageSender, times(1)).send(any(NewUserMessage.class), eq(null));
    }

    private User createUser() {
        User user = new User();
        user.setIdentity("Identity");
        return user;
    }
}
