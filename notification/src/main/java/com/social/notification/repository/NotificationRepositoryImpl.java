package com.social.notification.repository;

import com.social.notification.model.Notification;
import com.social.notification.repository.contract.NotificationRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class NotificationRepositoryImpl implements NotificationRepository {

    private final MongoTemplate mongoTemplate;

    public NotificationRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void createCollection(String collection) {
        mongoTemplate.createCollection(collection);
    }

    @Override
    public void save(Notification notification, String collection) {
        mongoTemplate.save(notification, collection);
    }
}
