package com.social.post.repository;

import com.social.post.repository.contract.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class PostRepositoryImpl implements PostRepository {

    private final MongoTemplate mongoTemplate;

    @Override
    public void createCollection(String collection) {
        mongoTemplate.createCollection(collection);
    }
}
