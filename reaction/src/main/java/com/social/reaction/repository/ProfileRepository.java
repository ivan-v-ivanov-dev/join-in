package com.social.reaction.repository;

import com.social.reaction.model.Profile;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ProfileRepository extends Neo4jRepository<Profile, String> {
}
