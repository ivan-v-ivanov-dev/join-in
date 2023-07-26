package com.social.post.repository;

import com.social.post.model.Comment;
import com.social.post.repository.contract.ProfileRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class ProfileRepositoryImpl implements ProfileRepository {

    private final MongoTemplate mongoTemplate;

    public ProfileRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Set<String> findAllUsersCommentingThePost(String postIdentity, String collection) {
        Set<String> authors = new HashSet<>();
        Query query = new Query(Criteria.where("postIdentity").is(postIdentity).all(Comment.class));
        mongoTemplate.find(query, Comment.class, collection).forEach(comment -> authors.add(comment.getAuthorIdentity()));
        return authors;
    }
}
