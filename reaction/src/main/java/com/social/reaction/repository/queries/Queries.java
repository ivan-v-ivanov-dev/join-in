package com.social.reaction.repository.queries;

public class Queries {

    public static final String FIND_HOW_MANY_PROFILES_LIKE_THE_POST_TEMPLATE =
            "MATCH (p:Profile)-[:LIKE]->(post:Post) WHERE post.identity = $postIdentity RETURN COUNT(DISTINCT p)";

    public static final String FIND_HOW_MANY_PROFILES_DISLIKE_THE_POST_TEMPLATE =
            "MATCH (p:Profile)-[:DISLIKE]->(post:Post) WHERE post.identity = $postIdentity RETURN COUNT(DISTINCT p)";

    public static final String FIND_HOW_MANY_PROFILES_STAR_THE_POST_TEMPLATE =
            "MATCH (p:Profile)-[:STAR]->(post:Post) WHERE post.identity = $postIdentity RETURN COUNT(DISTINCT p)";

    private Queries() {
    }
}
