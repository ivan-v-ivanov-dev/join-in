package com.social.message.repository;

import com.social.message.model.User;
import com.social.message.repository.contract.MessageRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class MessageRepositoryImpl implements MessageRepository {

    private final MongoTemplate mongoTemplate;

    public MessageRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Boolean isFriendOnline(String identity) {
        Query query = new Query(Criteria.where("identity").is(identity));
        return mongoTemplate.findDistinct(query, "online", "online_users", Boolean.class).get(0);
    }

    @Override
    public User findFriend(String identity) {
        Query query = new Query(Criteria.where("identity").is(identity));
        return mongoTemplate.findOne(query, User.class, "online_users");
    }
}
