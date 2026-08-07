package com.joinin.message.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table("messages_by_conversation")
public class ChatMessage {

    @PrimaryKey
    private ChatMessageKey key;

    @Column("sender_id")
    private String senderId;

    @Column("recipient_id")
    private String recipientId;

    @Column("content")
    private String content;
}
