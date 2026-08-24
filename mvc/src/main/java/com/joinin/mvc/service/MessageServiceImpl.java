package com.joinin.mvc.service;

import com.join_in.common_models.ConversationRpGatewayService;
import com.joinin.mvc.mappers.ConversationMapper;
import com.joinin.mvc.model.Conversation;
import com.joinin.mvc.service.contract.MessageService;
import com.joinin.mvc.service.feign.GatewayClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageServiceImpl implements MessageService {

    private final GatewayClient gatewayClient;
    private final ConversationMapper conversationMapper;

    @Override
    public List<Conversation> retrieveConversations(String identity) {
        List<ConversationRpGatewayService> conversationRpGatewayServices = gatewayClient.retrieveProfileConversations(identity);
        log.info("Retrieve conversations for profile: " + identity);
        return conversationRpGatewayServices
                .stream()
                .map(conversationMapper::fromConversationRpGatewayServicetoConversation)
                .toList();
    }

    @Override
    public String retrieveProfileOnlineStatus(String identity) {
        String status = gatewayClient.retrieveProfileOnlineStatus(identity);
        log.info("Retrieve online status for profile: " + identity);
        return status;
    }
}
