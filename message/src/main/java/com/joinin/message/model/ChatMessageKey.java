package com.joinin.message.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyClass
public class ChatMessageKey implements Serializable {

    @PrimaryKeyColumn(
            name = "conversation_id",
            type = PrimaryKeyType.PARTITIONED,
            ordinal = 0
    )
    private String conversationId;

    @PrimaryKeyColumn(
            name = "created_at",
            type = PrimaryKeyType.CLUSTERED,
            ordinal = 1,
            ordering = Ordering.ASCENDING
    )
    private LocalDateTime createdAt;

    @PrimaryKeyColumn(
            name = "message_id",
            type = PrimaryKeyType.CLUSTERED,
            ordinal = 2
    )
    private String messageId;
}