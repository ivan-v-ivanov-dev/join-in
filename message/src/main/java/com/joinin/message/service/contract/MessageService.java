package com.joinin.message.service.contract;

import com.join_in.common_models.ConversationRpMessageService;
import com.joinin.message.model.ChatMessage;

import java.util.List;

public interface MessageService {
    List<ConversationRpMessageService> retrieveConversations(String identity);

    List<ChatMessage> retrieveConversationMessages(String identity);
}
