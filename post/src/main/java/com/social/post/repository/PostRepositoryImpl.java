package com.social.post.repository;

import com.social.post.model.Post;
import com.social.post.repository.contract.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class PostRepositoryImpl implements PostRepository {

    private final MongoTemplate mongoTemplate;

    @Override
    public void createCollection(String collection) {
        mongoTemplate.createCollection(collection);
    }

    @Override
    public Post findByAuthorIdentityAndPostIdentity(String postIdentity, String collection) {
        Query query = new Query(Criteria.where("postIdentity").is(postIdentity));
        return mongoTemplate.findOne(query, Post.class, collection);
    }
}
