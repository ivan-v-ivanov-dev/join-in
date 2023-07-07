package com.social.post.repository;

import com.social.post.model.Comment;
import com.social.post.repository.contract.CommentRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CommentRepositoryImpl implements CommentRepository {

    private final RedisTemplate<String, Comment> redisTemplate;

    public CommentRepositoryImpl(RedisTemplate<String, Comment> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void save(Comment comment) {
        redisTemplate.opsForHash().put(comment.getPostIdentity(), comment.getCommentIdentity(), comment);
    }
}
