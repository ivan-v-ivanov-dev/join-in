package com.joinin.gateway.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class UpdateProfileOnlineStatusTopic {

    @Value("${spring.kafka.topic.update-profile-online-status}")
    private String updateProfileOnlineStatusTopic;
    @Value("${spring.kafka.partitions}")
    private int partitions;
    @Value("${spring.kafka.replicas}")
    private int replicas;

    @Bean
    NewTopic updateProfileOnlineStatus() {
        return TopicBuilder
                .name(updateProfileOnlineStatusTopic)
                .partitions(partitions)
                .replicas(replicas)
                .build();
    }
}
