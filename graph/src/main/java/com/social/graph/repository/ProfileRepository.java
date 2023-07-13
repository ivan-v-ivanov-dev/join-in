package com.social.graph.repository;

import com.social.graph.model.Profile;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ProfileRepository extends Neo4jRepository<Profile, Long> {

    Profile findByIdentity(String identity);
}
