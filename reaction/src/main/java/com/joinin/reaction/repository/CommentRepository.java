package com.joinin.reaction.repository;

import com.joinin.reaction.model.Comment;
import com.joinin.reaction.model.CommentReactionsCount;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends Neo4jRepository<Comment, String> {

    @Query("""
            MATCH (comment:Comment)
            WHERE comment.identity IN $identities
            
            OPTIONAL MATCH
                (:Profile)-[reaction:LIKE|DISLIKE]->(comment)
            
            RETURN
                comment.identity AS identity,
            
                sum(CASE
                    WHEN type(reaction) = 'LIKE' THEN 1
                    ELSE 0
                END) AS likeCount,
            
                sum(CASE
                    WHEN type(reaction) = 'DISLIKE' THEN 1
                    ELSE 0
                END) AS dislikeCount
            
            ORDER BY comment.identity
            """)
    List<CommentReactionsCount> retrieveCommentReactionsCount(@Param("identities") List<String> identities);

    @Query("""
            MATCH (:Profile)-[reaction:LIKE|DISLIKE]->(comment:Comment)
            WHERE comment.identity IN commentIdentities
            RETURN count(reaction)
            """)
    int retrieveCommentsReactionsCount(@Param("commentIdentities") List<String> commentIdentities);
}
