package com.social.post.repository;

import com.social.post.repository.contract.ImageRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import static com.social.post.repository.constants.Constants.PROFILE_IMAGE_FIELD;

@Repository
public class ImageRepositoryImpl implements ImageRepository {

    private final MongoTemplate mongoTemplate;

    public ImageRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public String findProfileImage(String collection) {
        return mongoTemplate.findDistinct(new Query(), PROFILE_IMAGE_FIELD, collection, String.class).get(0);
    }
}
