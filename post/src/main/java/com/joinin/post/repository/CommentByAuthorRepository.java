package com.joinin.post.repository;

import com.joinin.post.model.CommentByAuthorEntity;
import com.joinin.post.model.CommentByAuthorKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.CountQuery;

public interface CommentByAuthorRepository extends CassandraRepository<CommentByAuthorEntity, CommentByAuthorKey> {

    @CountQuery("""
            SELECT COUNT(*)
            FROM comments_by_author
            WHERE author_identity = ?0
            """)
    int countAuthorComments(String authorIdentity);
}
