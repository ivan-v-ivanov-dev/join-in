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
    void likePost(@Param("userIdentity") String userIdentity, @Param("postIdentity") String postIdentity);

    @Query(DELETE_POSSIBLE_PREVIOUS_REACTIONS)
    void deletePossiblePreviousRelations(@Param("userIdentity") String userIdentity, @Param("postIdentity") String postIdentity);
}
