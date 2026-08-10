package com.joinin.gateway.service;

import com.join_in.common_models.ConversationRpGatewayService;
import com.join_in.common_models.ConversationRpMessageService;
import com.joinin.gateway.mapper.ConversationMapper;
import com.joinin.gateway.service.contract.MessageService;
import com.joinin.gateway.service.feign.MessageServiceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageServiceImpl implements MessageService {

    private final MessageServiceClient messageServiceClient;
    private final ConversationMapper conversationMapper;

    @Override
    public List<ConversationRpGatewayService> retrieveProfileConversations(String identity) {
        List<ConversationRpMessageService> conversationRpMessageServices = messageServiceClient.retrieveConversations(identity);
        log.info("Retrieve conversations for profile: " + identity);
        return conversationRpMessageServices
                .stream()
                .map(conversationMapper::fromConversationRpMessageServicetoConversationRpGatewayService)
                .toList();
    }
}
