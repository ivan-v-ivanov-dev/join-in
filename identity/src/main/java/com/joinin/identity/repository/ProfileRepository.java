package com.joinin.identity.repository;

import com.joinin.identity.model.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProfileRepository {

    private final MongoTemplate mongoTemplate;

    public Profile save(Profile profile) {
        return mongoTemplate.save(profile);
    }

    public void updatePassword(String identity, String newPassword) {
        Query query = Query.query(Criteria.where("identity").is(identity));
        Update update = new Update().set("password", newPassword);
        mongoTemplate.updateFirst(query, update, Profile.class);
    }
}
