package com.social.notification.repository;

import com.social.notification.repository.contract.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class NotificationRepositoryImpl implements NotificationRepository {

    private final MongoTemplate mongoTemplate;

    @Override
    public void createCollection(String collection) {
        mongoTemplate.createCollection(collection);
    }
}
