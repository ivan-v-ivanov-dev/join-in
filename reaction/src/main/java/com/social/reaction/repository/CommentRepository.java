package com.social.reaction.repository;

import com.social.reaction.model.Comment;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CommentRepository extends Neo4jRepository<Comment, String> {
}
