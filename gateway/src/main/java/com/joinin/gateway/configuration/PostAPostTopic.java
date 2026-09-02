package com.joinin.gateway.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class PostAPostTopic {

    @Value("${spring.kafka.topic.post-a-post}")
    private String postAPostTopic;
    @Value("${spring.kafka.partitions}")
    private int partitions;
    @Value("${spring.kafka.replicas}")
    private int replicas;

    @Bean
    NewTopic postAPost() {
        return TopicBuilder
                .name(postAPostTopic)
                .partitions(partitions)
                .replicas(replicas)
                .build();
    }
}
