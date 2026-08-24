package com.joinin.gateway.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

public class UpdateProfileOfflineStatusTopic {
    @Value("${spring.kafka.topic.update-profile-offline-status}")
    private String updateProfileOfflineStatusTopic;
    @Value("${spring.kafka.partitions}")
    private int partitions;
    @Value("${spring.kafka.replicas}")
    private int replicas;

    @Bean
    NewTopic updateProfileOfflineStatus() {
        return TopicBuilder
                .name(updateProfileOfflineStatusTopic)
                .partitions(partitions)
                .replicas(replicas)
                .build();
    }
}
