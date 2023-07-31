package com.social.reaction.repository;

import com.social.reaction.model.Comment;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import static com.social.reaction.repository.queries.Queries.*;

public interface CommentRepository extends Neo4jRepository<Comment, String> {

    @Query(DELETE_COMMENT_NODE_WITH_RELATIONS)
    void deleteNodeWithRelations(@Param("identity") String identity);

    @Query(DELETE_POSSIBLE_PREVIOUS_REACTIONS_TO_THE_COMMENT)
    void deletePossiblePreviousRelations(@Param("reactingUserIdentity") String reactingUserIdentity,
                                         @Param("commentIdentity") String commentIdentity);

    @Query(USER_LIKES_COMMENT)
    void likeComment(@Param("reactingUserIdentity") String reactingUserIdentity,
                     @Param("commentIdentity") String commentIdentity);

    @Query(USER_DISLIKES_COMMENT)
    void dislikeComment(@Param("reactingUserIdentity") String reactingUserIdentity,
                        @Param("commentIdentity") String commentIdentity);
}
