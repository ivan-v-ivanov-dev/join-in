package com.social.reaction.repository;

import com.social.reaction.model.Post;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface PostRepository extends Neo4jRepository<Post, String> {
}
