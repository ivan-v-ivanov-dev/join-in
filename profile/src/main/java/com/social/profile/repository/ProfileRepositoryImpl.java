package com.social.profile.repository;

import com.social.profile.model.Profile;
import com.social.profile.repository.contract.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import static com.social.profile.repository.constants.RepositoryConstants.*;

@Repository
@AllArgsConstructor
public class ProfileRepositoryImpl implements ProfileRepository {

    private final MongoTemplate mongoTemplate;

    @Override
    public void createCollection(String collection) {
        mongoTemplate.createCollection(collection);
    }

    @Override
    public Profile findByIdentity(String identity) {
        Query query = Query.query(Criteria.where(IDENTITY_FIELD).is(identity));
        return mongoTemplate.findOne(query, Profile.class);
    }

    @Override
    public Profile findProfileNames(String identity) {
        Query query = new Query(Criteria.where(IDENTITY_FIELD).is(identity));
        query.fields().include(FIRST_NAME_FIELD).include(LAST_NAME_FIELD).exclude(ID_FIELD);
        return mongoTemplate.findOne(query, Profile.class);
    }
}
