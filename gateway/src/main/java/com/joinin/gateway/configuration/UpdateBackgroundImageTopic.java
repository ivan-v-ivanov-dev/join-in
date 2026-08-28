package com.joinin.gateway.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class UpdateBackgroundImageTopic {

    @Value("${spring.kafka.topic.update-background-image}")
    private String updateBackgroundImageTopic;
    @Value("${spring.kafka.partitions}")
    private int partitions;
    @Value("${spring.kafka.replicas}")
    private int replicas;

    @Bean
    NewTopic updateBackgroundImage() {
        return TopicBuilder
                .name(updateBackgroundImageTopic)
                .partitions(partitions)
                .replicas(replicas)
                .build();
    }
}
