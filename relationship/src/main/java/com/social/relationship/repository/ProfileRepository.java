package com.social.relationship.repository;

import com.social.relationship.model.Profile;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ProfileRepository extends Neo4jRepository<Profile, String> {
}
