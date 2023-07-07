package com.social.profile.service.contracts;

import com.social.kafka.messages.contract.KafkaMessage;

public interface KafkaMessageSender {
    void send(KafkaMessage kafkaMessage, String topic);
}
