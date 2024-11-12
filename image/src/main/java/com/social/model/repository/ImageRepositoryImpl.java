package com.social.model.repository;

import com.social.model.model.Image;
import com.social.model.repository.contract.ImageRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.social.model.repository.constants.RepositoryConstants.*;

@Repository
public class ImageRepositoryImpl implements ImageRepository {

    private final MongoTemplate mongoTemplate;

    public ImageRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Image findProfileImage(String collection) {
        Query profileQuery = Query.query(Criteria.where(TYPE).is(PROFILE));
        return mongoTemplate.findOne(profileQuery, Image.class, collection);
    }

    @Override
    public Image findProfileBackgroundImage(String collection) {
        Query profileQuery = Query.query(Criteria.where(TYPE).is(BACKGROUND));
        return mongoTemplate.findOne(profileQuery, Image.class, collection);
    }

    public List<Image> findProfileAlbumImages(String collectionName) {
        Query query = new Query(Criteria.where(TYPE).is(ALBUM));
        return mongoTemplate.find(query, Image.class, collectionName);
    }

    @Override
    public void createCollection(String collection) {
        mongoTemplate.createCollection(collection);
    }
}
