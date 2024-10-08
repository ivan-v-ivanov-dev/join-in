package com.social.relationship.repository;

import com.social.relationship.model.Profile;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import static com.social.relationship.repository.queries.Queries.CREATE_FRIENDSHIP_RELATIONSHIP_BETWEEN_SENDER_AND_RECIPIENT;
import static com.social.relationship.repository.queries.Queries.CREATE_FRIENDSHIP_REQUEST_RELATIONSHIP_BETWEEN_SENDER_AND_RECIPIENT;

public interface ProfileRepository extends Neo4jRepository<Profile, String> {

    @Query(CREATE_FRIENDSHIP_RELATIONSHIP_BETWEEN_SENDER_AND_RECIPIENT)
    void createFriendshipRelationship(@Param("senderUserIdentity") String senderUserIdentity,
                                      @Param("recipientUserIdentity") String recipientUserIdentity);

    @Query(CREATE_FRIENDSHIP_REQUEST_RELATIONSHIP_BETWEEN_SENDER_AND_RECIPIENT)
    void createFriendshipRequestRelationship(@Param("senderUserIdentity") String senderUserIdentity,
                                             @Param("recipientUserIdentity") String recipientUserIdentity);
}
