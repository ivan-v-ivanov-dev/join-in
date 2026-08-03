package com.joinin.post.repository;

import com.joinin.post.model.PostByAuthorEntity;
import com.joinin.post.model.PostByAuthorKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.CountQuery;
import org.springframework.data.cassandra.repository.Query;

import java.util.List;

public interface PostByAuthorRepository extends CassandraRepository<PostByAuthorEntity, PostByAuthorKey> {

    @Query("""
            SELECT *
            FROM posts_by_author
            WHERE author_identity = ?0
            """)
    List<PostByAuthorEntity> findAllByAuthorIdentity(String authorIdentity);

    @CountQuery("""
            SELECT COUNT(*)
            FROM posts_by_author
            WHERE author_identity = ?0
            """)
    int retrieveProfilePostsCount(String identity);
}
