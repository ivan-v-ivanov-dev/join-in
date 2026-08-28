package com.joinin.gateway.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class UpdateProfilePasswordTopic {
    @Value("${spring.kafka.topic.update-profile-password}")
    private String updateProfilePasswordTopic;
    @Value("${spring.kafka.partitions}")
    private int partitions;
    @Value("${spring.kafka.replicas}")
    private int replicas;

    @Bean
    NewTopic updateProfilePassword() {
        return TopicBuilder
                .name(updateProfilePasswordTopic)
                .partitions(partitions)
                .replicas(replicas)
                .build();
    }
}
