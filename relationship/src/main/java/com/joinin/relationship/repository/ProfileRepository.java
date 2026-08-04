package com.joinin.relationship.repository;

import com.joinin.relationship.model.FamilyMember;
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

    @Query("""
            MATCH (requester:Profile)
                  -[:FRIENDSHIP_REQUEST]->
                  (:Profile {identity: $identity})
            RETURN DISTINCT requester
            ORDER BY requester.identity
            """)
    List<ProfileNode> findFriendshipRequestsByIdentity(@Param("identity") String identity);

    @Query("""
            MATCH (profile:Profile {identity: $identity})
            MATCH (familyMember:Profile)-[relationship:
                SON |
                DAUGHTER |
                MOTHER |
                FATHER |
                SISTER |
                BROTHER
            ]->(profile)
            RETURN DISTINCT
                familyMember.identity AS identity,
                type(relationship) AS relationshipType
            ORDER BY relationshipType, identity
            """)
    List<FamilyMember> findAllFamilyMembers(@Param("identity") String identity);
}
