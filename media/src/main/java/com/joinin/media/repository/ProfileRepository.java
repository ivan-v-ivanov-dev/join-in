package com.joinin.media.repository;

import com.joinin.media.model.AlbumPictureUrl;
import com.joinin.media.model.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
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

    public void updateProfileImage(String identity, String mongoProfileUrl) {
        Query query = new Query(Criteria.where("identity").is(identity));
        Update update = new Update().set("profilePictureUrl", mongoProfileUrl);
        mongoTemplate.updateFirst(query, update, Profile.class);
    }

    public void updateBackgroundImage(String identity, String mongoBackgroundPictureUrl) {
        Query query = new Query(Criteria.where("identity").is(identity));
        Update update = new Update().set("backgroundPictureUrl", mongoBackgroundPictureUrl);
        mongoTemplate.updateFirst(query, update, Profile.class);
    }

    public AlbumPictureUrl retrieveOldestAlbumImage(String identity) {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("identity").is(identity)),
                Aggregation.unwind("albumPictureUrls"),
                Aggregation.sort(Sort.Direction.ASC, "albumPictureUrls.uploadedOn"),
                Aggregation.limit(1),
                Aggregation.replaceRoot("albumPictureUrls"));

        return mongoTemplate
                .aggregate(aggregation, "profiles", AlbumPictureUrl.class)
                .getUniqueMappedResult();
    }

    public void updateAlbumImageUrl(String identity, AlbumPictureUrl albumImage) {
        Query query = new Query(Criteria.where("identity").is(identity));
        Update update = new Update().push("albumPictureUrls", albumImage);
        mongoTemplate.updateFirst(query, update, Profile.class);
    }

    public void deleteOldestAlbumImage(String identity, AlbumPictureUrl albumImageUrl) {
        Query query = Query.query(Criteria.where("identity").is(identity));
        Update update = new Update()
                .pull("albumPictureUrls", Query.query(Criteria.where("url").is(albumImageUrl.getUrl())));
        mongoTemplate.updateFirst(query, update, Profile.class);
    }
}
