package com.social.image.service;

import com.social.image.service.contract.ImageService;
import com.social.kafka.messages.NewUserMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ImageListenerTest {

    @Mock
    ImageService imageService;
    @InjectMocks
    ImageListener imageListener;

    @Test
    public void listener_should_callService() {
        NewUserMessage newUserMessage = NewUserMessage.builder().identity("identity").build();
        imageListener.listener(newUserMessage);

        verify(imageService, times(1)).createCollection(newUserMessage.getIdentity());
    }
}
