package com.joinin.media.repository;

import com.joinin.media.model.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProfileRepository {

    private static final String PROFILES_COLLECTION = "profiles";
    private final MongoTemplate mongoTemplate;

    public Profile save(Profile profile) {
        return mongoTemplate.save(profile, PROFILES_COLLECTION);
    }
}
