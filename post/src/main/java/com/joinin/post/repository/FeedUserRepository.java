package com.joinin.post.repository;

import com.joinin.post.model.FeedUserEntity;
import com.joinin.post.model.FeedUserPrimaryKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import java.util.List;

public interface FeedUserRepository extends CassandraRepository<FeedUserEntity, FeedUserPrimaryKey> {

    @Query("""
            SELECT *
            FROM feed_by_user
            WHERE user_identity = ?0
            """)
    List<FeedUserEntity> findFeedByUserIdentity(String userIdentity);
}
