package com.social.profile.repository;

import com.social.profile.model.Profile;
import com.social.profile.repository.contract.ProfileRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import static com.social.profile.repository.constants.Constants.*;

@Repository
public class ProfileRepositoryImpl implements ProfileRepository {

    private final MongoTemplate mongoTemplate;

    public ProfileRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Profile findByIdentity(String identity) {
        return mongoTemplate.findOne(Query.query(Criteria.where(IDENTITY_FIELD).is(identity)), Profile.class);
    }

    @Override
    public Profile save(Profile profile) {
        return mongoTemplate.save(profile);
    }

    @Override
    public String findProfileFirstName(String identity) {
        return mongoTemplate.findDistinct(new Query(), FIRST_NAME_FIELD, PROFILES_COLLECTION, String.class).get(0);
    }

    @Override
    public String findProfileLastName(String identity) {
        return mongoTemplate.findDistinct(new Query(), LAST_NAME_FIELD, PROFILES_COLLECTION, String.class).get(0);
    }
}
