package com.joinin.identity.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class NewRegisteredUserInfoTopicConfiguration {

    @Value("${spring.kafka.topic.new-registered-user-info}")
    private String newRegisteredUserInfo;
    @Value("${spring.kafka.partitions}")
    private int partitions;
    @Value("${spring.kafka.replicas}")
    private int replicas;

    @Bean
    NewTopic newRegisteredUserInfoTopicBean() {
        return TopicBuilder
                .name(newRegisteredUserInfo)
                .partitions(partitions)
                .replicas(replicas)
                .build();
    }
}
