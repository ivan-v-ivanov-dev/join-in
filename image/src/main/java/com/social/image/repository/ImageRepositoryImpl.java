package com.social.image.repository;

import com.social.image.repository.contract.ImageRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.social.image.repository.constants.Constants.*;

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

    @Override
    public String findProfileBackgroundImage(String collection) {
        return mongoTemplate.findDistinct(new Query(), BACKGROUND_IMAGE_FIELD, collection, String.class).get(0);
    }

    @Override
    public List<String> findProfileAlbumImage(String collection) {
        return mongoTemplate.findDistinct(new Query(), ALBUM_IMAGES_FIELD, collection, String.class);
    }
}
