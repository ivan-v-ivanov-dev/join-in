package com.social.message.repository;

import com.social.message.model.User;
import com.social.message.repository.contract.MessageRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class MessageRepositoryImpl implements MessageRepository {

    private final MongoTemplate mongoTemplate;

    public MessageRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void userIsOnline(String identity) {
        Query query = new Query(Criteria.where("identity").is(identity));
        Update update = new Update().set("online", true);
        mongoTemplate.updateFirst(query, update, User.class, "online_users");
    }

    @Override
    public void userIsOffline(String identity) {
        Query query = new Query(Criteria.where("identity").is(identity));
        Update update = new Update().set("online", false);
        mongoTemplate.updateFirst(query, update, User.class, "online_users");
    }

    @Override
    public boolean findUserOnlineStatus(String identity) {
        Query query = new Query(Criteria.where("identity").is(identity));
        User user = mongoTemplate.findOne(query, User.class, "online_users");
        return user != null && user.isOnline();
    }
}
