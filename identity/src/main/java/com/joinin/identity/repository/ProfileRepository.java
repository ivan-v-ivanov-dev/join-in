package com.joinin.identity.repository;

import com.joinin.identity.model.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProfileRepository {

    private final MongoTemplate mongoTemplate;

    public Profile save(Profile profile) {
        return mongoTemplate.insert(profile);
    }
}
