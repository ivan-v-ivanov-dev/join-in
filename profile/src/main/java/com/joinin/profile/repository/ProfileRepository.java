package com.joinin.profile.repository;

import com.joinin.profile.models.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProfileRepository {

    private final MongoTemplate mongoTemplate;

    public Profile save(Profile profile) {
        return mongoTemplate.save(profile);
    }

    public Profile retrieveProfileByIdentity(String identity) {
        Query query = new Query(Criteria.where("identity").is(identity));
        return mongoTemplate.findOne(query, Profile.class);
    }
}
