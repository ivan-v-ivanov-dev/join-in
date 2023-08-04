package com.social.authentication.service;

import com.social.authentication.model.User;
import com.social.authentication.repository.UserRepository;
import com.social.kafka.messages.contract.KafkaMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RegisterServiceImplTest {

    @Mock
    UserRepository userRepository;
    @Mock
    KafkaTemplate<String, KafkaMessage> kafkaTemplate;
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
    public void save_shouldCallKafkaTemplate() {
        User user = createUser();
        when(userRepository.save(user)).thenReturn(user);
        registerService.save(user);
        ArgumentCaptor<Message<KafkaMessage>> messageCaptor = ArgumentCaptor.forClass(Message.class);
        verify(kafkaTemplate, times(1)).send(messageCaptor.capture());
    }

    private User createUser() {
        User user = new User();
        user.setIdentity("Identity");
        return user;
    }
}
