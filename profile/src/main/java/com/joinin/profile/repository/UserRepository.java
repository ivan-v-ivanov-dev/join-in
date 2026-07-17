package com.joinin.profile.repository;

import com.joinin.profile.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final MongoTemplate mongoTemplate;

    public User save(User user) {
        return mongoTemplate.save(user);
    }
}
