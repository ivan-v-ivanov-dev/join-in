package com.social.authentication.config;

import com.social.kafka.messages.contract.KafkaMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

import static com.social.authentication.config.ConfigConstants.KAFKA_CONFIG_CREATE_DEFAULT_PRODUCER_FACTORY_FOR_KAFKA_MESSAGE;
import static com.social.authentication.config.ConfigConstants.KAFKA_CONFIG_CREATE_KAFKA_TEMPLATE_FOR_KAFKA_MESSAGE;

@Configuration
@EnableKafka
@Slf4j
public class KafkaConfig {

    @Value("${spring.kafka.producer.bootstrap-servers}")
    private String producerServer;

    @Bean
    public ProducerFactory<String, KafkaMessage> producerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, this.producerServer);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        DefaultKafkaProducerFactory<String, KafkaMessage> defaultKafkaProducerFactory = new DefaultKafkaProducerFactory<>(props);
        log.info(KAFKA_CONFIG_CREATE_DEFAULT_PRODUCER_FACTORY_FOR_KAFKA_MESSAGE);

        return defaultKafkaProducerFactory;
    }

    @Bean
    public KafkaTemplate<String, KafkaMessage> kafkaTemplate() {
        KafkaTemplate<String, KafkaMessage> kafkaTemplate = new KafkaTemplate<>(producerFactory());
        log.info(KAFKA_CONFIG_CREATE_KAFKA_TEMPLATE_FOR_KAFKA_MESSAGE);

        return kafkaTemplate;
    }

}