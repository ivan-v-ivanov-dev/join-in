package com.social.notification.repository;

import com.social.notification.model.Notification;
import com.social.notification.repository.contract.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class NotificationRepositoryImpl implements NotificationRepository {

    private final MongoTemplate mongoTemplate;

    @Override
    public void createCollection(String collection) {
        mongoTemplate.createCollection(collection);
    }

    @Override
    public List<Notification> findProfileNotifications(String collection) {
        Sort sort = Sort.by(Sort.Direction.DESC, "date");
        Query query = Query.query(Criteria.where("seen").is(false)).with(sort);
        return mongoTemplate.find(query, Notification.class, collection);
    }
}
