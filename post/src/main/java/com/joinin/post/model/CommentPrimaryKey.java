package com.joinin.post.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyClass
public class CommentPrimaryKey implements Serializable {

    @PrimaryKeyColumn(
            name = "post_identity",
            type = PrimaryKeyType.PARTITIONED,
            ordinal = 0
    )
    private String postIdentity;

    @PrimaryKeyColumn(
            name = "created_at",
            type = PrimaryKeyType.CLUSTERED,
            ordinal = 1
    )
    private Instant createdAt;

    @PrimaryKeyColumn(
            name = "comment_identity",
            type = PrimaryKeyType.CLUSTERED,
            ordinal = 2
    )
    private String commentIdentity;
}
