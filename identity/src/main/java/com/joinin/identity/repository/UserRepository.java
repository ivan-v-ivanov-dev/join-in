package com.joinin.identity.repository;

import com.joinin.identity.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final MongoTemplate mongoTemplate;

    public void save(User user) {
        mongoTemplate.insert(user);
    }
}
