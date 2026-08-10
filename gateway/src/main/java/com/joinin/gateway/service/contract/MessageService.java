package com.joinin.gateway.service.contract;

import com.join_in.common_models.ConversationRpGatewayService;

import java.util.List;

public interface MessageService {
    List<ConversationRpGatewayService> retrieveProfileConversations(String identity);
}
