package com.joinin.notification.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class NotificationRepository {

    private final MongoTemplate mongoTemplate;

    public boolean createCollection(String collection) {
        if (mongoTemplate.collectionExists(collection)) {
            return false;
        }
        mongoTemplate.createCollection(collection);
        return true;
    }
}
