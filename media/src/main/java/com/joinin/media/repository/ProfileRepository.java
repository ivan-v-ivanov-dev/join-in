package com.joinin.media.repository;

import com.joinin.media.model.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProfileRepository {

    private final MongoTemplate mongoTemplate;

    public Profile save(Profile profile) {
        return mongoTemplate.save(profile);
    }

    public Profile getProfileByIdentity(String identity) {
        Query query = Query.query(Criteria.where("identity").is(identity));
        return mongoTemplate.findOne(query, Profile.class);
    }

    public List<Profile> retrieveProfilesByIdentities(List<String> identities) {
        Query query = Query.query(Criteria.where("identity").in(identities));
        return mongoTemplate.find(query, Profile.class);
    }

    public void updateProfilePicture(String identity, String mongoProfileUrl) {
        Query query = new Query(Criteria.where("identity").is(identity));
        Update update = new Update().set("profilePictureUrl", mongoProfileUrl);
        mongoTemplate.updateFirst(query, update, Profile.class);
    }
}
