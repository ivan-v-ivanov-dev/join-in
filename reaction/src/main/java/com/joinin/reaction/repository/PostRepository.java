package com.joinin.reaction.repository;

import com.joinin.reaction.model.Post;
import com.joinin.reaction.model.PostReactionsCount;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends Neo4jRepository<Post, String> {

    @Query("""
        MATCH (post:Post)
        WHERE post.identity IN $identities

        OPTIONAL MATCH (:Profile)-[reaction:LIKE|DISLIKE|HAHA|ANGRY]->(post)

        RETURN
            post.identity AS identity,

            sum(CASE
                WHEN type(reaction) = 'LIKE' THEN 1
                ELSE 0
            END) AS likeCount,

            sum(CASE
                WHEN type(reaction) = 'DISLIKE' THEN 1
                ELSE 0
            END) AS dislikeCount,

            sum(CASE
                WHEN type(reaction) = 'HAHA' THEN 1
                ELSE 0
            END) AS hahaCount,

            sum(CASE
                WHEN type(reaction) = 'ANGRY' THEN 1
                ELSE 0
            END) AS angryCount
        """)
    List<PostReactionsCount> retrievePostReactionsCount(@Param("identities") List<String> identities);
}
