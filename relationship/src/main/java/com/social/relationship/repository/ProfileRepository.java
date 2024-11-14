package com.social.relationship.repository;

import com.social.relationship.model.Profile;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

import static com.social.relationship.repository.queries.Queries.*;

public interface ProfileRepository extends Neo4jRepository<Profile, String> {

    @Query(CREATE_FRIENDSHIP_RELATIONSHIP_BETWEEN_SENDER_AND_RECIPIENT)
    void createFriendshipRelationship(@Param("senderUserIdentity") String senderUserIdentity,
                                      @Param("recipientUserIdentity") String recipientUserIdentity);

    @Query(CREATE_FRIENDSHIP_REQUEST_RELATIONSHIP_BETWEEN_SENDER_AND_RECIPIENT)
    void createFriendshipRequestRelationship(@Param("senderUserIdentity") String senderUserIdentity,
                                             @Param("recipientUserIdentity") String recipientUserIdentity);

    @Query(FIND_THE_FRIENDS_FOR_A_PROFILE_BY_PROFILE_IDENTITY_TEMPLATE)
    Set<String> findFriendsByProfileIdentity(@Param("identity") String identity);

    @Query(FIND_FRIENDSHIP_REQUESTS_FOR_A_PROFILE_BY_PROFILE_IDENTITY_TEMPLATE)
    Set<String> findFriendshipRequestsByProfileIdentity(@Param("identity") String identity);

    @Query(FIND_FRIENDS_COUNT_FOR_A_PROFILE_TEMPLATE)
    int findFriendsCountByProfileIdentity(@Param("identity") String identity);
}
