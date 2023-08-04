package com.social.authentication.service;

import com.social.authentication.model.User;
import com.social.authentication.repository.LogRepository;
import com.social.authentication.repository.UserRepository;
import com.social.authentication.service.contract.PasswordEncoder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LoginServiceImplTest {

    @Mock
    LogRepository logRepository;
    @Mock
    UserRepository userRepository;
    @Mock
    PasswordEncoder passwordEncoder;
    @InjectMocks
    LoginServiceImpl loginService;

    private String identity;
    private String email;
    private String password;

    @BeforeEach
    public void init() {
        identity = "identity";
        email = "email";
        password = "password";
    }

    @Test
    public void login_should_returnUserIdentity_when_credentialsAreRight() {
        User loggedUser = createUser(identity, password);

        when(userRepository.findByEmail(email)).thenReturn(loggedUser);
        when(passwordEncoder.areEqual(password, loggedUser.getPassword())).thenReturn(true);

        assertEquals(identity, loginService.login(email, password));
    }

    @Test
    public void login_should_throwException_when_credentialsAreWrong() {
        User loggedUser = createUser(identity, password);

        when(userRepository.findByEmail(email)).thenReturn(loggedUser);
        when(passwordEncoder.areEqual(password, loggedUser.getPassword())).thenReturn(false);

        assertThrows(IllegalArgumentException.class, () -> loginService.login(email, password));
    }

    private User createUser(String identity, String password) {
        return User.builder().identity(identity).password(password).build();
    }
}
