package com.social.post.repository;

import com.social.post.model.Post;
import com.social.post.repository.contract.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List<Post> findPostsByAuthorIdentity(String collection) {
        Query query = new Query()
                .with(Sort.by(Sort.Order.desc("postDate")))
                .limit(3);
        return mongoTemplate.find(query, Post.class, collection);
    }
}
