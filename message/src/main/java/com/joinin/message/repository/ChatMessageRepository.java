package com.joinin.message.repository;

import com.joinin.message.model.ChatMessage;
import com.joinin.message.model.ChatMessageKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMessageRepository extends CassandraRepository<ChatMessage, ChatMessageKey> {

    @Query("""
        SELECT *
        FROM messages_by_conversation
        WHERE conversation_id = ?0
        """)
    List<ChatMessage> retrieveConversationMessages(String conversationId);
}
