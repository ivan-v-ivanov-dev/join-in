package com.social.reaction.repository.queries;

public class Queries {

    public static final String FIND_HOW_MANY_PROFILES_LIKE_THE_POST_TEMPLATE =
            "MATCH (profile:Profile)-[:LIKE]->(post:Post) " +
                    "WHERE post.identity = $postIdentity " +
                    "RETURN COUNT(DISTINCT profile)";

    public static final String FIND_HOW_MANY_PROFILES_DISLIKE_THE_POST_TEMPLATE =
            "MATCH (profile:Profile)-[:DISLIKE]->(post:Post) " +
                    "WHERE post.identity = $postIdentity " +
                    "RETURN COUNT(DISTINCT profile)";

    public static final String FIND_HOW_MANY_PROFILES_STAR_THE_POST_TEMPLATE =
            "MATCH (profile:Profile)-[:STAR]->(post:Post) " +
                    "WHERE post.identity = $postIdentity " +
                    "RETURN COUNT(DISTINCT profile)";

    public static final String FIND_USER_IDENTITIES_WHO_REACTED_TO_THE_POST =
            "MATCH (profile:Profile)-[:LIKE|DISLIKE|STAR]->(post:Post) " +
                    "WHERE post.identity = $postIdentity " +
                    "RETURN DISTINCT profile.identity";

    public static final String DELETE_COMMENT_NODE_WITH_RELATIONS =
            "MATCH (c:Comment) WHERE c.identity = $identity DETACH DELETE c";

    public static final String DELETE_POST_NODE_WITH_RELATIONS =
            "MATCH (p:Post) WHERE p.identity = $identity DETACH DELETE p";

    public static final String USER_LIKES_POST =
            "MATCH (profile:Profile), (post:Post) " +
                    "WHERE profile.identity = $userIdentity AND " +
                    "post.identity = $postIdentity " +
                    "MERGE (profile)-[:LIKE]->(post)";

    public static final String DELETE_POSSIBLE_PREVIOUS_REACTIONS =
            "OPTIONAL MATCH (profile:Profile)-[reaction:LIKE|STAR|DISLIKE]->(post:Post) " +
                    "WHERE profile.identity = $userIdentity AND post.identity = $postIdentity " +
                    "DELETE reaction";

    private Queries() {
    }
}
