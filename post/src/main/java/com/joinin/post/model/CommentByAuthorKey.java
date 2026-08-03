package com.joinin.post.model;

import lombok.*;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serial;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString
@EqualsAndHashCode
@PrimaryKeyClass
public class CommentByAuthorKey {

    @Serial
    private static final long serialVersionUID = 1L;

    @PrimaryKeyColumn(
            name = "author_identity",
            ordinal = 0,
            type = PrimaryKeyType.PARTITIONED
    )
    private String authorIdentity;

    @PrimaryKeyColumn(
            name = "created_at",
            ordinal = 1,
            type = PrimaryKeyType.CLUSTERED,
            ordering = Ordering.DESCENDING
    )
    private LocalDateTime createdAt;

    @PrimaryKeyColumn(
            name = "comment_identity",
            ordinal = 2,
            type = PrimaryKeyType.CLUSTERED,
            ordering = Ordering.ASCENDING
    )
    private String commentIdentity;
}
