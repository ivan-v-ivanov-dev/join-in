package com.joinin.post.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyClass
public class FeedUserPrimaryKey implements Serializable {

    private static final long serialVersionUID = 1L;

    /*
     * The user whose feed contains the post.
     *
     * This is the Cassandra partition key.
     */
    @PrimaryKeyColumn(
            name = "user_identity",
            type = PrimaryKeyType.PARTITIONED,
            ordinal = 0
    )
    private String userIdentity;

    /*
     * The post creation time.
     *
     * Posts are sorted from newest to oldest.
     */
    @PrimaryKeyColumn(
            name = "created_at",
            type = PrimaryKeyType.CLUSTERED,
            ordinal = 1,
            ordering = Ordering.DESCENDING
    )
    private LocalDateTime createdAt;

    /*
     * Distinguishes posts that have the same creation timestamp.
     */
    @PrimaryKeyColumn(
            name = "post_identity",
            type = PrimaryKeyType.CLUSTERED,
            ordinal = 2,
            ordering = Ordering.ASCENDING
    )
    private String postIdentity;
}
