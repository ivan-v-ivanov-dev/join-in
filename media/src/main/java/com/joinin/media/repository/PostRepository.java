package com.joinin.media.repository;

import com.joinin.media.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Repository
@RequiredArgsConstructor
public class PostRepository {

    private final MongoTemplate mongoTemplate;

    public Post retrieveByIdentity(String identity) {
        Query query = Query.query(where("identity").is(identity));
        return mongoTemplate.findOne(query, Post.class);
    }

    public void save(Post post) {
        mongoTemplate.save(post);
    }
}
