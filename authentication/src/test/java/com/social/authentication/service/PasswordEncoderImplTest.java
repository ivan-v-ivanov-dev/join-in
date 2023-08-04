package com.social.authentication.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PasswordEncoderImplTest {

    @Mock
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @InjectMocks
    PasswordEncoderImpl passwordEncoder;

    private final String queryPassword = "password";
    private final String wrongQueryPassword = "wrong";
    private final String databasePassword = "password";

    @Test
    public void areEqual_returnsTrue_when_passwordsAreEqual() {
        when(bCryptPasswordEncoder.matches(queryPassword, databasePassword)).thenReturn(true);
        assertTrue(passwordEncoder.areEqual(queryPassword, databasePassword));
    }

    @Test
    public void areEqual_returnsFalse_when_passwordsAreEqual() {
        when(bCryptPasswordEncoder.matches(wrongQueryPassword, databasePassword)).thenReturn(false);
        assertFalse(passwordEncoder.areEqual(wrongQueryPassword, databasePassword));
    }

    @Test
    public void encode_shouldCallEncoder() {
        passwordEncoder.encode(queryPassword);
        verify(bCryptPasswordEncoder, times(1)).encode(queryPassword);
    }
}
