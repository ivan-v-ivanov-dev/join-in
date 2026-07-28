package com.joinin.post.repository;

import com.joinin.post.model.PostByGroupEntity;
import com.joinin.post.model.PostByGroupKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import java.util.List;

public interface PostByGroupRepository extends CassandraRepository<PostByGroupEntity, PostByGroupKey> {

    @Query("""
        SELECT *
        FROM posts_by_group
        WHERE group_identity = ?0
        """)
    List<PostByGroupEntity> findAllByGroupIdentity(String groupIdentity);
}
