package com.joinin.message.service.contract;

import com.joinin.message.model.ChatMessage;
import com.joinin.message.model.MessageByConversation;

import java.util.List;

public interface MessageService {
    List<MessageByConversation> retrieveConversations(String identity);

    List<ChatMessage> retrieveConversationMessages(String identity);
}
