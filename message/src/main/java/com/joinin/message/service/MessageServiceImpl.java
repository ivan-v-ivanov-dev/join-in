package com.joinin.message.service;

import com.joinin.message.model.ChatMessage;
import com.joinin.message.model.MessageByConversation;
import com.joinin.message.repository.ChatMessageRepository;
import com.joinin.message.repository.ConversationRepository;
import com.joinin.message.service.contract.MessageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class MessageServiceImpl implements MessageService {

    private final ChatMessageRepository chatMessageRepository;
    private final ConversationRepository conversationRepository;

    @Override
    public List<MessageByConversation> retrieveConversations(String identity) {
        List<MessageByConversation> conversations = conversationRepository.findConversationsByUserId(identity);
        log.info("Retrieve conversations for profile: " + identity);
        return conversations;
    }

    @Override
    public List<ChatMessage> retrieveConversationMessages(String identity) {
        List<ChatMessage> chatMessages = chatMessageRepository.retrieveConversationMessages(identity);
        log.info("Retrieve conversation messages for conversation: " + identity);
        return chatMessages;
    }
}
