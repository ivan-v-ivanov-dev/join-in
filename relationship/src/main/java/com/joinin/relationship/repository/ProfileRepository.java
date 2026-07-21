package com.joinin.relationship.repository;

import com.joinin.relationship.model.ProfileNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ProfileRepository extends Neo4jRepository<ProfileNode, String> {
}
