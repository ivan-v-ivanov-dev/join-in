package com.social.profile.repository;

import com.social.profile.model.Profile;
import com.social.profile.repository.contract.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import static com.social.profile.repository.constants.RepositoryConstants.IDENTITY_FIELD;

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
}
