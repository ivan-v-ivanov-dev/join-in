package com.joinin.identity.repository;

import com.joinin.identity.model.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class EmailRepository {

    private final MongoTemplate mongoTemplate;

    public boolean existsByEmail(String email) {
        Query query = Query.query(Criteria.where("email").is(email));
        return !mongoTemplate.exists(query, Profile.class);
    }
}
