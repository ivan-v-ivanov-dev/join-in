package com.social.authentication.service;

import com.social.authentication.model.User;
import com.social.authentication.repository.UserRepository;
import com.social.authentication.service.contract.IdentityGenerator;
import com.social.authentication.service.contract.KafkaMessageSender;
import com.social.authentication.service.contract.PasswordEncoder;
import com.social.kafka.messages.NewUserMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;

import static com.social.authentication.service.constants.ExceptionConstants.USER_ALREADY_EXISTS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RegisterServiceImplTest {

    @Mock
    UserRepository userRepository;
    @Mock
    PasswordEncoder passwordEncoder;
    @Mock
    IdentityGenerator identityGenerator;
    @Mock
    KafkaMessageSender kafkaMessageSender;
    @InjectMocks
    RegisterServiceImpl registerService;

    @Value("${spring.kafka.topic.name.new.user}")
    private String newUserTopic;

    @BeforeEach
    public void setUp() {
        registerService = new RegisterServiceImpl(userRepository, passwordEncoder,
                identityGenerator, kafkaMessageSender, newUserTopic);
    }

    @Test
    public void shouldRegisterUserSuccessfully() {
        String email = "test@example.com";
        String password = "password";
        String encodedPassword = "encodedPassword";
        String identity = "identity";

        when(userRepository.findByEmail(email)).thenReturn(null);
        when(passwordEncoder.encode(password)).thenReturn(encodedPassword);
        when(identityGenerator.generate(email)).thenReturn(identity);
        when(userRepository.save(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));

        registerService.register(email, password);

        verify(userRepository).findByEmail(email);
        verify(passwordEncoder).encode(password);
        verify(identityGenerator).generate(email);
        verify(userRepository).save(any(User.class));
        verify(kafkaMessageSender).send(any(NewUserMessage.class), eq(newUserTopic));
    }

    @Test
    public void shouldThrowExceptionWhenUserAlreadyExists() {
        String email = "test@example.com";
        String password = "password";

        when(userRepository.findByEmail(email)).thenReturn(new User());

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            registerService.register(email, password);
        });

        assertEquals(USER_ALREADY_EXISTS, exception.getMessage());
        verify(userRepository).findByEmail(email);
        verifyNoMoreInteractions(userRepository, passwordEncoder, identityGenerator, kafkaMessageSender);
    }

    @Test
    public void shouldLogWarnWhenUserAlreadyExists() {
        // Implement this test to verify the warning log message if needed
    }
}
