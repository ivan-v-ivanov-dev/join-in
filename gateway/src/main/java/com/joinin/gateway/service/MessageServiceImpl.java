package com.joinin.gateway.service;

import com.join_in.common_models.ConversationRpGatewayService;
import com.join_in.common_models.ConversationRpMessageService;
import com.join_in.kafka_models.KafkaMessage;
import com.join_in.kafka_models.messages.UpdateProfileOfflineStatus;
import com.join_in.kafka_models.messages.UpdateProfileOnlineStatus;
import com.joinin.gateway.mapper.ConversationMapper;
import com.joinin.gateway.service.contract.MessageService;
import com.joinin.gateway.service.feign.MessageServiceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageServiceImpl implements MessageService {

    private final MessageServiceClient messageServiceClient;
    private final ConversationMapper conversationMapper;
    private final KafkaTemplate<String, KafkaMessage> kafkaTemplate;

    @Value("${spring.kafka.topic.update-profile-online-status}")
    private String updateProfileOnlineStatusTopic;
    @Value("${spring.kafka.topic.update-profile-offline-status}")
    private String updateProfileOfflineStatusTopic;

    @Override
    public List<ConversationRpGatewayService> retrieveProfileConversations(String identity) {
        List<ConversationRpMessageService> conversationRpMessageServices = messageServiceClient.retrieveConversations(identity);
        log.info("Retrieve conversations for profile: " + identity);
        return conversationRpMessageServices
                .stream()
                .map(conversationMapper::fromConversationRpMessageServicetoConversationRpGatewayService)
                .toList();
    }

    @Override
    public void updateProfileOnlineStatus(String identity) {
        KafkaMessage message = new UpdateProfileOnlineStatus(identity);
        kafkaTemplate.send(updateProfileOnlineStatusTopic, message);
        log.info("Update profile online status received from MVC module and sent in topic: " + updateProfileOnlineStatusTopic);
    }

    @Override
    public void updateProfileOfflineStatus(String identity) {
        KafkaMessage message = new UpdateProfileOfflineStatus(identity);
        kafkaTemplate.send(updateProfileOfflineStatusTopic, message);
        log.info("Update profile offline status received from MVC module and sent in topic: " + updateProfileOfflineStatusTopic);
    }
}
