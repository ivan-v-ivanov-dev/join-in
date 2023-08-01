package com.social.notification.repository;

import com.social.notification.model.Notification;
import com.social.notification.repository.contract.NotificationRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List<Notification> findUserNotifications(String collection) {
        Sort sort = Sort.by(Sort.Direction.DESC, "date");
        Query query = Query.query(Criteria.where("seen").is(false)).with(sort);
        return mongoTemplate.find(query, Notification.class, collection);
    }
}
