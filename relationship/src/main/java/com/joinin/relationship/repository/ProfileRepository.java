package com.joinin.relationship.repository;

import com.joinin.relationship.model.ProfileNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProfileRepository extends Neo4jRepository<ProfileNode, String> {

    @Query("""
        MATCH (:Profile {identity: $identity})
              -[:FRIEND]->(friend:Profile)
        RETURN friend
        """)
    List<ProfileNode> findAllFriendsByIdentity(@Param("identity") String identity);

    @Query("""
        OPTIONAL MATCH (profile:Profile {identity: $identity})
        OPTIONAL MATCH (profile)-[:FRIEND]->(friend:Profile)
        RETURN count(DISTINCT friend) AS friendCount
        """)
    int countAllFriendsByIdentity(@Param("identity") String identity);
}
