package com.social.profile.service;

import com.social.gateway.service.AuthenticationServiceImpl;
import com.social.gateway.service.feign.AuthenticationClient;
import feign.FeignException;
import feign.Request;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.ResourceAccessException;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class AuthenticationServiceImplTest {

    @Mock
    private AuthenticationClient authenticationClient;


    @InjectMocks
    private AuthenticationServiceImpl authenticationService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLoginSuccess() {
        String email = "test@example.com";
        String password = "password";
        String expectedLoginResponse = "success-token";

        when(authenticationClient.login(email, password)).thenReturn(expectedLoginResponse);

        String actualResponse = authenticationService.login(email, password);

        assertEquals(expectedLoginResponse, actualResponse, "Login should return the expected token.");
    }

    @Test
    public void testLoginInvalidCredentials() {
        String email = "test@example.com";
        String password = "wrong-password";

        when(authenticationClient.login(anyString(), anyString()))
                .thenThrow(new IllegalArgumentException("Invalid credentials"));

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                () -> {
                    authenticationService.login(email, password);
                });

        assertEquals("Invalid credentials", thrownException.getMessage(),
                "Exception message should match.");
    }

    @Test
    public void testLoginServiceDown() {
        String email = "test@example.com";
        String password = "password";
        Request request = Request.create(
                Request.HttpMethod.POST,
                "http://localhost:8081",
                Collections.emptyMap(),
                null,
                null,
                null
        );

        when(authenticationClient.login(anyString(), anyString()))
                .thenThrow(new FeignException.InternalServerError("Service unavailable", request, new byte[0]));

        ResourceAccessException thrownException = assertThrows(ResourceAccessException.class, () -> {
            authenticationService.login(email, password);
        });

        assertEquals("Authentication Service :: Resource not available or service is down",
                thrownException.getMessage(), "Exception message should match.");
    }

}
