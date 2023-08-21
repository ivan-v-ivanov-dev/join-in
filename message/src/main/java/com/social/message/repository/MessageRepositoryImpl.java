package com.social.message.repository;

import com.social.message.model.Chat;
import com.social.message.model.ChatMessage;
import com.social.message.model.User;
import com.social.message.repository.contract.MessageRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    public List<String> findUserDirectChatIdentities(String identity) {
        Query query = new Query(Criteria.where("userIdentity").is(identity));
        query.with(Sort.by(Sort.Direction.ASC, "identity"));
        return mongoTemplate.findDistinct(query, "chatIdentities", "direct_chat_identities", String.class);
    }

    @Override
    public List<ChatMessage> findDirectChatMessages(String collection) {
        Query query = new Query();
        query.with(Sort.by(Sort.Direction.ASC, "date"));
        return mongoTemplate.findDistinct(query, "messages", collection, ChatMessage.class);
    }

    @Override
    public void saveMessage(ChatMessage chatMessage, String chatIdentity, String collection) {
        Query query = new Query(Criteria.where("chatIdentity").is(chatIdentity));
        Update update = new Update().push("messages", chatMessage);

        mongoTemplate.updateFirst(query, update, Chat.class, collection);
    }
}
