package com.social.reaction.repository;

public class Queries {

    public static final String FIND_HOW_MANY_PROFILES_LIKE_THE_POST_TEMPLATE =
            """
            MATCH (profile:Profile)-[:LIKE]->(post:Post)  
            WHERE post.identity = $postIdentity  
            RETURN COUNT(DISTINCT profile) 
            """;

    private Queries() {
    }
}
