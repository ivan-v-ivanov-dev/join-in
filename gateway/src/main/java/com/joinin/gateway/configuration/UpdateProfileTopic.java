package com.joinin.gateway.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class UpdateProfileTopic {

    @Value("${spring.kafka.topic.update-profile}")
    private String updateProfileTopic;
    @Value("${spring.kafka.partitions}")
    private int partitions;
    @Value("${spring.kafka.replicas}")
    private int replicas;

    @Bean
    NewTopic updateProfile() {
        return TopicBuilder
                .name(updateProfileTopic)
                .partitions(partitions)
                .replicas(replicas)
                .build();
    }
}
