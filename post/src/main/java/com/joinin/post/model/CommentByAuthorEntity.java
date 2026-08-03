package com.joinin.post.model;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString
@Table("comments_by_author")
public class CommentByAuthorEntity {

    @PrimaryKey
    private CommentByAuthorKey key;

    @Column("post_identity")
    private String postIdentity;

    @Column("content")
    private String content;
}
