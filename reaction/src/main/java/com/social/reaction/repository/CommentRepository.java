package com.social.reaction.repository;

import com.social.reaction.model.Comment;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import static com.social.reaction.repository.queries.Queries.DELETE_COMMENT_NODE_WITH_RELATIONS;

public interface CommentRepository extends Neo4jRepository<Comment, String> {

    @Query(DELETE_COMMENT_NODE_WITH_RELATIONS)
    void deleteNodeWithRelations(@Param("identity") String identity);
}
