package com.social.post.repository;

import com.social.post.model.Comment;
import com.social.post.model.Post;
import com.social.post.repository.contract.PostRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Repository
public class PostRepositoryImpl implements PostRepository {

    private final MongoTemplate mongoTemplate;

    public PostRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Post findByPostIdentity(String postIdentity, String collection) {
        Query query = new Query(Criteria.where("postIdentity").is(postIdentity));
        return mongoTemplate.findOne(query, Post.class, collection);
    }

    @Override
    public void save(Post post, String collection) {
        mongoTemplate.save(post, collection);
    }

    @Override
    public List<Post> findAllPostsByAuthorIdentity(String collection) {
        return mongoTemplate.findAll(Post.class, collection);
    }

    @Override
    public void delete(String postIdentity, String collection) {
        Query query = new Query(Criteria.where("postIdentity").is(postIdentity));
        mongoTemplate.remove(query, Post.class, collection);
    }

    @Override
    public void updateOne(String postIdentity, String newContent, String collection) {
        Query query = new Query(Criteria.where("postIdentity").is(postIdentity));
        mongoTemplate.updateFirst(query, Update.update("content", newContent), Post.class, collection);
    }

    @Override
    public int findAuthorPostsCount(String collection) {
        return (int) mongoTemplate.count(new Query(), collection);
    }

    @Override
    public void createNewUserCollection(String collection) {
        mongoTemplate.createCollection(collection);
    }

    @Override
    public void saveComment(Comment comment, String postIdentity, String collection) {
        Query query = new Query(Criteria.where("postIdentity").is(postIdentity));
        Update update = new Update().push("comments", comment);
        mongoTemplate.updateFirst(query, update, Post.class, collection);
    }

    @Override
    public Set<String> findAllCommentIdentitiesForAPost(String postIdentity, String collection) {
        Set<String> commentIdentities = new LinkedHashSet<>();
        Query query = new Query(Criteria.where("postIdentity").is(postIdentity));
        mongoTemplate.find(query, Post.class, collection)
                .forEach(post -> post.getComments()
                                .forEach(comment -> commentIdentities.add(comment.getCommentIdentity())));
        return commentIdentities;
    }
}
