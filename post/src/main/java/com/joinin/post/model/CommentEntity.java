package com.joinin.post.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("comments_by_post")
public class CommentEntity {

    @PrimaryKey
    private CommentPrimaryKey primaryKey;

    @Column("author_identity")
    private String authorIdentity;

    @Column("content")
    private String content;

    @Column("edited_at")
    private Instant editedAt;

    @Column("is_deleted")
    private boolean deleted;

    @Column("parent_comment_identity")
    private String parentCommentIdentity;
}