package com.social.post.repository;

import com.social.post.model.Post;
import com.social.post.repository.contract.PostRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostRepositoryImpl implements PostRepository {

    private final MongoTemplate mongoTemplate;

    public PostRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Post findByPostIdentity(String postIdentity) {
        Query query = new Query(Criteria.where("postIdentity").is(postIdentity));
        return mongoTemplate.findOne(query, Post.class, "posts");
    }

    @Override
    public void save(Post post) {
        mongoTemplate.save(post, "posts");
    }

    @Override
    public List<Post> findAllPostsByAuthorIdentity(String authorIdentity) {
        Query query = new Query(Criteria.where("authorIdentity").is(authorIdentity));
        return mongoTemplate.find(query, Post.class, "posts");
    }

    @Override
    public void delete(String postIdentity) {
        Query query = new Query(Criteria.where("postIdentity").is(postIdentity));
        mongoTemplate.remove(query, Post.class);
    }

    @Override
    public void updateOne(String postIdentity, String newContent) {
        Query query = new Query(Criteria.where("postIdentity").is(postIdentity));
        mongoTemplate.updateFirst(query, Update.update("content", newContent), Post.class, "posts");
    }

    @Override
    public int findAuthorPostsCount(String authorIdentity) {
        Query query = new Query(Criteria.where("authorIdentity").is(authorIdentity));
        return (int) mongoTemplate.count(query, Post.class, "posts");
    }
}
