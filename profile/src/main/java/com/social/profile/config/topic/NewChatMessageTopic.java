package com.social.profile.config.topic;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;

import static com.social.profile.config.ConfigConstants.KAFKA_TOPIC_FOR_NEW_CHAT_MESSAGE_TEMPLATE;

@Configuration
@EnableKafka
@Slf4j
public class NewChatMessageTopic {

    @Value("${spring.kafka.topic.name.new.chat.message}")
    private String topicName;
    @Value("${spring.kafka.partitions}")
    private String partitions;
    @Value("${spring.kafka.replicas}")
    private String replicas;

    @Bean
    public NewTopic newChatMessageTopicForMessageService() {
        NewTopic chatMessageTopicForMessageService = TopicBuilder
                .name(topicName)
                .partitions(Integer.parseInt(partitions))
                .replicas(Integer.parseInt(replicas))
                .build();
        log.info(String.format(KAFKA_TOPIC_FOR_NEW_CHAT_MESSAGE_TEMPLATE, topicName));

        return chatMessageTopicForMessageService;
    }
}
