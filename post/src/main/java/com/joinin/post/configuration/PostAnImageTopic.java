package com.joinin.post.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class PostAnImageTopic {

    @Value("${spring.kafka.topic.post-an-image}")
    private String postAnImageTopic;
    @Value("${spring.kafka.partitions}")
    private int partitions;
    @Value("${spring.kafka.replicas}")
    private int replicas;

    @Bean
    NewTopic postAnImage() {
        return TopicBuilder
                .name(postAnImageTopic)
                .partitions(partitions)
                .replicas(replicas)
                .build();
    }
}
