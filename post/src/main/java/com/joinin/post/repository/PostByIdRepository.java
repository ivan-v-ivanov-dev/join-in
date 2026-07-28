package com.joinin.post.repository;

import com.joinin.post.model.PostByIdEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface PostByIdRepository extends CassandraRepository<PostByIdEntity, String> {
}
