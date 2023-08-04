package com.social.reaction.service;

import com.social.kafka.messages.contract.KafkaMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class KafkaMessageSenderImplTest {

    @Mock
    KafkaTemplate<String, KafkaMessage> kafkaTemplate;

    @InjectMocks
    KafkaMessageSenderImpl kafkaMessageSender;

    @Test
    public void send_shouldSendMessageToKafkaTopic() {
        kafkaMessageSender.send(mock(KafkaMessage.class), anyString());

        ArgumentCaptor<Message<KafkaMessage>> messageCaptor = ArgumentCaptor.forClass(Message.class);
        verify(kafkaTemplate, times(1)).send(messageCaptor.capture());
    }
}
