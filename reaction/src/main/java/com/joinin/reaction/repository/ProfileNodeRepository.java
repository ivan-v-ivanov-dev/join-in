package com.joinin.reaction.repository;

import com.joinin.reaction.model.ProfileNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ProfileNodeRepository extends Neo4jRepository<ProfileNode, String> {
}
