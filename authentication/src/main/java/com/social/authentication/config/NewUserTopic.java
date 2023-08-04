package com.social.authentication.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;

import static com.social.authentication.config.ConfigConstants.KAFKA_TOPIC_FOR_NEW_USER_CREATED_TEMPLATE;

@Configuration
@EnableKafka
@Slf4j
public class NewUserTopic {

    @Value("${spring.kafka.topic.name.new.user}")
    private String topicName;
    @Value("${spring.kafka.partitions}")
    private String partitions;
    @Value("${spring.kafka.replicas}")
    private String replicas;

    @Bean
    public NewTopic newUserTopicForMultipleServices() {
        NewTopic registeredUserTopicForProfileService = TopicBuilder
                .name(topicName)
                .partitions(Integer.parseInt(partitions))
                .replicas(Integer.parseInt(replicas))
                .build();
        log.info(String.format(KAFKA_TOPIC_FOR_NEW_USER_CREATED_TEMPLATE, topicName));

        return registeredUserTopicForProfileService;
    }
}
