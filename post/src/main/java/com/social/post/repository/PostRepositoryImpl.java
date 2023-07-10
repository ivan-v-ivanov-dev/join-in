package com.social.post.repository;

import com.social.post.model.Post;
import com.social.post.repository.contract.PostRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostRepositoryImpl implements PostRepository {

    private final MongoTemplate mongoTemplate;

    public PostRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void save(Post post) {
        mongoTemplate.save(post);
    }

    @Override
    public List<Post> findAllPostsByAuthorIdentity(String authorIdentity) {
        return mongoTemplate.find(new Query(Criteria.where("authorIdentity").is(authorIdentity)), Post.class, "posts");
    }
}
