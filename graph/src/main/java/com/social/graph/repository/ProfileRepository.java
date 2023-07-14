package com.social.graph.repository;

import com.social.graph.model.Profile;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import static com.social.graph.repository.queries.Queries.FIND_THE_FRIENDS_FOR_A_PROFILE_BY_PROFILE_IDENTITY_TEMPLATE;

public interface ProfileRepository extends Neo4jRepository<Profile, String> {

    Profile findByIdentity(String identity);

    @Query(FIND_THE_FRIENDS_FOR_A_PROFILE_BY_PROFILE_IDENTITY_TEMPLATE)
    List<Profile> findFriendsByProfileIdentity(@Param("identity") String identity);
}
