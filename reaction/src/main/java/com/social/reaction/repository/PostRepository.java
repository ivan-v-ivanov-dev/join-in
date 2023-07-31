package com.social.reaction.repository;

import com.social.reaction.model.Post;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import static com.social.reaction.repository.queries.Queries.*;

public interface PostRepository extends Neo4jRepository<Post, String> {

    @Query(DELETE_POST_NODE_WITH_RELATIONS)
    void deleteNodeWithRelations(@Param("identity") String postIdentity);

    @Query(USER_LIKES_POST)
    void likePost(@Param("reactingUserIdentity") String reactingUserIdentity, @Param("postIdentity") String postIdentity);

    @Query(DELETE_POSSIBLE_PREVIOUS_REACTIONS_TO_THE_POST)
    void deletePossiblePreviousRelations(@Param("reactingUserIdentity") String reactingUserIdentity,
                                         @Param("postIdentity") String postIdentity);

    @Query(USER_DISLIKES_POST)
    void dislikePost(@Param("reactingUserIdentity") String reactingUserIdentity, @Param("postIdentity") String postIdentity);

    @Query(USER_STARS_POST)
    void starPost(@Param("reactingUserIdentity") String reactingUserIdentity, @Param("postIdentity") String postIdentity);
}
