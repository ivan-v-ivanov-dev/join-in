package com.social.relationship.repository;

import com.social.relationship.model.Profile;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

import static com.social.relationship.repository.queries.Queries.*;

public interface ProfileRepository extends Neo4jRepository<Profile, String> {

    @Query(FIND_THE_FRIENDS_FOR_A_PROFILE_BY_PROFILE_IDENTITY_TEMPLATE)
    Set<String> findFriendsByProfileIdentity(@Param("identity") String identity);

    @Query(FIND_HOW_MANY_FRIENDS_HAS_A_PROFILE_TEMPLATE)
    int findFriendCountByProfileIdentity(@Param("identity") String identity);

    @Query(FIND_THE_FRIENDSHIP_REQUESTS_FOR_A_PROFILE_BY_PROFILE_IDENTITY_TEMPLATE)
    Set<String> findFriendshipRequestByProfileIdentity(String identity);
}
