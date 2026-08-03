package com.joinin.post.repository;

import com.joinin.post.model.CommentByPostEntity;
import com.joinin.post.model.CommentByPostPrimaryKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import java.util.List;

public interface CommentByPostRepository extends CassandraRepository<CommentByPostEntity, CommentByPostPrimaryKey> {

    @Query("""
            SELECT *
            FROM comments_by_post
            WHERE post_identity = ?0
            """)
    List<CommentByPostEntity> findByPostIdentity(String postIdentity);
}
