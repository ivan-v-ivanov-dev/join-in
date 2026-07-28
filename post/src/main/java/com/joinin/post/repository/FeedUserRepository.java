package com.joinin.post.repository;

import com.joinin.post.model.FeedUserEntity;
import com.joinin.post.model.FeedUserPrimaryKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface FeedUserRepository extends CassandraRepository<FeedUserEntity, FeedUserPrimaryKey> {

    @Query("""
            SELECT *
            FROM feed_by_user
            WHERE user_identity = ?0
            """)
    Slice<FeedUserEntity> findFeedByUserIdentity(String userIdentity, Pageable pageable);
}
