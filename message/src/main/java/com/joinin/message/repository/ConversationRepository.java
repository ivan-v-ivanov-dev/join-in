package com.joinin.message.repository;

import com.joinin.message.model.MessageByConversation;
import com.joinin.message.model.MessageByConversationKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConversationRepository extends CassandraRepository<MessageByConversation, MessageByConversationKey> {

    @Query("""
            SELECT *
            FROM conversations_by_user
            WHERE user_id = ?0
            """)
    List<MessageByConversation> findConversationsByUserId(String userId);
}