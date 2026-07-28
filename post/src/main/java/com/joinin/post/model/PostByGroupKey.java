package com.joinin.post.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;
import java.time.LocalDateTime;

@PrimaryKeyClass
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class PostByGroupKey implements Serializable {

    @PrimaryKeyColumn(
            name = "group_identity",
            ordinal = 0,
            type = PrimaryKeyType.PARTITIONED
    )
    private String groupIdentity;

    @PrimaryKeyColumn(
            name = "created_at",
            ordinal = 1,
            type = PrimaryKeyType.CLUSTERED,
            ordering = Ordering.DESCENDING
    )
    private LocalDateTime createdAt;

    @PrimaryKeyColumn(
            name = "post_identity",
            ordinal = 2,
            type = PrimaryKeyType.CLUSTERED,
            ordering = Ordering.ASCENDING
    )
    private String postIdentity;
}