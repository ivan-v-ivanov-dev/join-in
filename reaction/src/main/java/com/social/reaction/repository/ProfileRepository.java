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
    int findPostDislikesCount(@Param("postIdentity") String postIdentity);

    @Query(FIND_HOW_MANY_PROFILES_STAR_THE_POST_TEMPLATE)
    int findPostStarsCount(@Param("postIdentity") String postIdentity);

    @Query(FIND_USER_IDENTITIES_WHO_LIKED_THE_POST)
    Set<String> findProfileIdentitiesWhoLikedThePost(@Param("postIdentity") String postIdentity);

    @Query(FIND_USER_IDENTITIES_WHO_DISLIKED_THE_POST)
    Set<String> findProfileIdentitiesWhoDislikedThePost(@Param("postIdentity") String postIdentity);

    @Query(FIND_USER_IDENTITIES_WHO_STARED_THE_POST)
    Set<String> findProfileIdentitiesWhoStaredThePost(@Param("postIdentity") String postIdentity);

    @Query(FIND_HOW_MANY_PROFILES_LIKE_THE_COMMENT_TEMPLATE)
    int findCommentLikesCount(@Param("commentIdentity") String commentIdentity);

    @Query(FIND_HOW_MANY_PROFILES_DISLIKE_THE_COMMENT_TEMPLATE)
    int findCommentDislikesCount(@Param("commentIdentity") String commentIdentity);
}
