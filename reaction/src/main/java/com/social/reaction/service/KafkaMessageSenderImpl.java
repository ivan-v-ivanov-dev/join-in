package com.social.reaction.service;

import com.social.kafka.messages.contract.KafkaMessage;
import com.social.reaction.service.contracts.KafkaMessageSender;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class KafkaMessageSenderImpl implements KafkaMessageSender {

    private final KafkaTemplate<String, KafkaMessage> kafkaTemplate;

    public KafkaMessageSenderImpl(KafkaTemplate<String, KafkaMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void send(KafkaMessage kafkaMessage, String topic) {
        Message<KafkaMessage> message = MessageBuilder
                .withPayload(kafkaMessage)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .build();
        kafkaTemplate.send(message);
    }
}
