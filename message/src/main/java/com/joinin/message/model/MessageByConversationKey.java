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
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyClass
public class MessageByConversationKey implements Serializable {

    @PrimaryKeyColumn(
            name = "user_id",
            type = PrimaryKeyType.PARTITIONED,
            ordinal = 0
    )
    private String userId;

    @PrimaryKeyColumn(
            name = "last_message_at",
            type = PrimaryKeyType.CLUSTERED,
            ordinal = 1,
            ordering = Ordering.DESCENDING
    )
    private LocalDateTime lastMessageAt;

    @PrimaryKeyColumn(
            name = "conversation_id",
            type = PrimaryKeyType.CLUSTERED,
            ordinal = 2)
    private String conversationId;
}
