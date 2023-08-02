package com.social.relationship.repository;

import com.social.relationship.model.Profile;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

import static com.social.relationship.repository.queries.Queries.*;

public interface ProfileRepository extends Neo4jRepository<Profile, String> {

    @Query(FIND_THE_FRIENDS_FOR_A_PROFILE_BY_PROFILE_IDENTITY_TEMPLATE)
    Set<String> findFriendsByProfileIdentity(@Param("identity") String identity);

    @Query(FIND_HOW_MANY_FRIENDS_HAS_A_PROFILE_TEMPLATE)
    int findFriendCountByProfileIdentity(@Param("identity") String identity);

    @Query(FIND_THE_FRIENDSHIP_REQUESTS_FOR_A_PROFILE_BY_PROFILE_IDENTITY_TEMPLATE)
    Set<String> findFriendshipRequestByProfileIdentity(@Param("identity") String identity);

    @Query(FIND_HOW_MANY_FRIENDSHIP_REQUESTS_HAS_A_PROFILE_TEMPLATE)
    int findFriendshipRequestCountByProfileIdentity(@Param("identity") String identity);

    @Query(DELETE_FRIENDSHIP_REQUEST_RELATIONSHIP_BETWEEN_SENDER_AND_RECIPIENT)
    void deleteFriendshipRequestRelationship(@Param("senderUserIdentity") String senderUserIdentity,
                                             @Param("recipientUserIdentity") String recipientUserIdentity);

    @Query(CREATE_FRIENDSHIP_RELATIONSHIP_BETWEEN_SENDER_AND_RECIPIENT)
    void createFriendshipRelationship(@Param("senderUserIdentity") String senderUserIdentity,
                                      @Param("recipientUserIdentity") String recipientUserIdentity);

    @Query(DELETE_FRIEND_RELATIONSHIP_BETWEEN_SENDER_AND_RECIPIENT)
    void deleteFriendRelationship(@Param("senderUserIdentity") String senderUserIdentity,
                                  @Param("recipientUserIdentity") String recipientUserIdentity);

    @Query(FIND_TEN_FRIEND_SUGGESTIONS)
    List<String> findFriendSuggestions(@Param("currentUserIdentity") String currentUserIdentity);
}
