package com.joinin.gateway.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class UploadAlbumImage {
    @Value("${spring.kafka.topic.upload-album-image}")
    private String uploadAlbumImageTopic;
    @Value("${spring.kafka.partitions}")
    private int partitions;
    @Value("${spring.kafka.replicas}")
    private int replicas;

    @Bean
    NewTopic uploadAlbumImage() {
        return TopicBuilder
                .name(uploadAlbumImageTopic)
                .partitions(partitions)
                .replicas(replicas)
                .build();
    }
}
