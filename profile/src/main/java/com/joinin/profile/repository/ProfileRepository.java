package com.joinin.profile.repository;

import com.joinin.profile.models.Profile;
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

    public Profile retrieveProfileByIdentity(String identity) {
        Query query = new Query(Criteria.where("identity").is(identity));
        return mongoTemplate.findOne(query, Profile.class);
    }


    public List<Profile> retrieveProfilesByIdentities(List<String> identities) {
        Query query = new Query(Criteria.where("identity").in(identities));
        return mongoTemplate.find(query, Profile.class);
    }

    public void update(Profile profile) {
        Query query = Query.query(Criteria.where("identity").is(profile.getIdentity()));
        Update update = new Update()
                .set("firstName", profile.getFirstName())
                .set("lastName", profile.getLastName())
                .set("aboutMe", profile.getAboutMe())
                .set("mobile", profile.getMobile())
                .set("address", profile.getAddress())
                .set("birthDate", profile.getBirthDate())
                .set("birthYear", profile.getBirthYear())
                .set("birthplace", profile.getBirthplace())
                .set("livesIn", profile.getLivesIn())
                .set("gender", profile.getGender())
                .set("interestedIn", profile.getInterestedIn())
                .set("language", profile.getLanguage())
                .set("joined", profile.getJoined())
                .set("status", profile.getStatus())
                .set("phoneNumber", profile.getPhoneNumber())
                .set("website", profile.getWebsite())
                .set("socialLink", profile.getSocialLink())
                .set("hobbies", profile.getHobbies())
                .set("work", profile.getWork())
                .set("professionalSkills", profile.getProfessionalSkills())
                .set("college", profile.getCollege())
                .set("currentCity", profile.getCurrentCity())
                .set("hometown", profile.getHometown())
                .set("otherPlacesLived", profile.getOtherPlacesLived());

        mongoTemplate.updateFirst(query, update, Profile.class);
    }
}
