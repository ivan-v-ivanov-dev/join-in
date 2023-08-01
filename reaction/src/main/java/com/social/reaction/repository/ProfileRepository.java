package com.social.reaction.repository;

import com.social.reaction.model.Profile;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

import static com.social.reaction.repository.queries.Queries.*;

public interface ProfileRepository extends Neo4jRepository<Profile, String> {

    @Query(FIND_HOW_MANY_PROFILES_LIKE_THE_POST_TEMPLATE)
    int findLikesAPostProfileCount(@Param("postIdentity") String postIdentity);

    @Query(FIND_HOW_MANY_PROFILES_LIKE_THE_COMMENT_TEMPLATE)
    int findLikesACommentProfileCount(@Param("commentIdentity") String commentIdentity);

    @Query(FIND_HOW_MANY_PROFILES_DISLIKE_THE_POST_TEMPLATE)
    int findDislikesAPostProfileCount(@Param("postIdentity") String postIdentity);

    @Query(FIND_HOW_MANY_PROFILES_DISLIKE_THE_COMMENT_TEMPLATE)
    int findDislikesACommentProfileCount(@Param("commentIdentity") String commentIdentity);

    @Query(FIND_HOW_MANY_PROFILES_STAR_THE_POST_TEMPLATE)
    int findStarsAPostProfileCount(@Param("postIdentity") String postIdentity);

    @Query(FIND_USER_IDENTITIES_WHO_REACTED_TO_THE_POST)
    Set<String> findPeopleWhoReactedToPost(@Param("postIdentity") String postIdentity);

    @Query(FIND_USER_IDENTITIES_WHO_LIKED_THE_POST)
    Set<String> findPeopleWhoLikedThePost(@Param("postIdentity") String postIdentity);

    @Query(FIND_USER_IDENTITIES_WHO_DISLIKED_THE_POST)
    Set<String> findPeopleWhoDislikedThePost(@Param("postIdentity") String postIdentity);

    @Query(FIND_USER_IDENTITIES_WHO_STARED_THE_POST)
    Set<String> findPeopleWhoStaredThePost(@Param("postIdentity") String postIdentity);
}
