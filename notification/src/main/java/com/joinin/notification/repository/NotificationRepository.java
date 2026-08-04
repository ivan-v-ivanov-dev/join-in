package com.joinin.notification.repository;

import com.joinin.notification.model.Notification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public List<Notification> retrieveNotificationForProfile(String collection) {
        Query query = Query.query(Criteria.where("seen").is(false));
        query.with(Sort.by(Sort.Direction.DESC, "createdAt"));
        return mongoTemplate.find(query, Notification.class, collection);
    }
}
