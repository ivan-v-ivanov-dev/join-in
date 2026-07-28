package com.joinin.post.repository;

import com.joinin.post.model.CommentEntity;
import com.joinin.post.model.CommentPrimaryKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import java.util.List;

public interface CommentRepository extends CassandraRepository<CommentEntity, CommentPrimaryKey> {

    @Query("""
            SELECT *
            FROM comments_by_post
            WHERE post_identity = ?0
            """)
    List<CommentEntity> findByPostIdentity(String postIdentity);
}
