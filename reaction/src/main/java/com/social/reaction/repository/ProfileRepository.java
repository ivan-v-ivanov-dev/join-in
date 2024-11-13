package com.social.reaction.repository;

import com.social.reaction.model.Profile;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

import static com.social.reaction.repository.queries.Queries.*;

public interface ProfileRepository extends Neo4jRepository<Profile, String> {

    @Query(FIND_HOW_MANY_PROFILES_LIKE_THE_POST_TEMPLATE)
    int findPostLikesCount(@Param("postIdentity") String postIdentity);

    @Query(FIND_HOW_MANY_PROFILES_DISLIKE_THE_POST_TEMPLATE)
    int findPostDislikesCount(String postIdentity);

    @Query(FIND_USER_IDENTITIES_WHO_LIKED_THE_POST)
    Set<String> findProfileIdentitiesWhoLikedThePost(@Param("postIdentity")  String postIdentity);

}
