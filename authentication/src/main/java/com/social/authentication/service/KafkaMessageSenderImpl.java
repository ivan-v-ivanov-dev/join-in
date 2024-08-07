package com.social.authentication.service;

import com.social.authentication.service.contract.KafkaMessageSender;
import com.social.kafka.messages.contract.KafkaMessage;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaMessageSenderImpl implements KafkaMessageSender {

    private final KafkaTemplate<String, KafkaMessage> kafkaTemplate;

    @Override
    public void send(KafkaMessage kafkaMessage, String topic) {
        Message<KafkaMessage> message = MessageBuilder
                .withPayload(kafkaMessage)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .build();
        kafkaTemplate.send(message);
    }
}