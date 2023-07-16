package com.social.relationship.repository;

import com.social.relationship.model.Profile;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import static com.social.relationship.repository.queries.Queries.*;

public interface ProfileRepository extends Neo4jRepository<Profile, String> {

    Profile findByIdentity(String identity);

    @Query(FIND_THE_FRIENDS_FOR_A_PROFILE_BY_PROFILE_IDENTITY_TEMPLATE)
    List<Profile> findFriendsByProfileIdentity(@Param("identity") String identity);

    @Query(FIND_HOW_MANY_PROFILES_LIKE_THE_POST_TEMPLATE)
    int findLikesAPostProfileCount(@Param("postIdentity") String postIdentity);

    @Query(FIND_HOW_MANY_PROFILES_DISLIKE_THE_POST_TEMPLATE)
    int findDislikesAPostProfileCount(@Param("postIdentity") String postIdentity);

    @Query(FIND_HOW_MANY_PROFILES_STAR_THE_POST_TEMPLATE)
    int findStarsAPostProfileCount(String postIdentity);
}
