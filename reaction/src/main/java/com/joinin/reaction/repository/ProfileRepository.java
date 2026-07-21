package com.joinin.reaction.repository;

import com.joinin.reaction.model.ProfileNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ProfileRepository extends Neo4jRepository<ProfileNode, String> {
}
