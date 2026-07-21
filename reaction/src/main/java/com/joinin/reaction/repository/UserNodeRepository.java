package com.joinin.reaction.repository;

import com.joinin.reaction.model.UserNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface UserNodeRepository extends Neo4jRepository<UserNode, String> {
}
