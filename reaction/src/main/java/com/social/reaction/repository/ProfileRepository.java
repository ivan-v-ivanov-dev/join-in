package com.social.reaction.repository;

import com.social.reaction.model.Profile;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import static com.social.reaction.repository.Queries.FIND_HOW_MANY_PROFILES_LIKE_THE_POST_TEMPLATE;

public interface ProfileRepository extends Neo4jRepository<Profile, String> {

    @Query(FIND_HOW_MANY_PROFILES_LIKE_THE_POST_TEMPLATE)
    int findPostLikesCount(String postIdentity);
}
