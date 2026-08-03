package com.joinin.post.repository;

import com.joinin.post.model.CommentByAuthorEntity;
import com.joinin.post.model.CommentByAuthorKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.CountQuery;
import org.springframework.data.cassandra.repository.Query;

import java.util.List;

public interface CommentByAuthorRepository extends CassandraRepository<CommentByAuthorEntity, CommentByAuthorKey> {

    @CountQuery("""
            SELECT COUNT(*)
            FROM comments_by_author
            WHERE author_identity = ?0
            """)
    int countAuthorComments(String authorIdentity);

    @Query("""
            SELECT comment_identity
            FROM comments_by_author
            WHERE author_identity = ?0
            """)
    List<String> retrieveCommentIdentitiesByAuthor(String authorIdentity);

    @Query("""
            SELECT author_identity,
                   created_at,
                   comment_identity
            FROM comments_by_author
            WHERE author_identity = ?0
            """)
    List<CommentByAuthorEntity> retrieveCommentsByAuthor(String authorIdentity);
}
