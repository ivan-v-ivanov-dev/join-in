package com.social.reaction.repository.queries;

public class Queries {

    public static final String FIND_HOW_MANY_PROFILES_LIKE_THE_POST_TEMPLATE =
            """
            MATCH (profile:Profile)-[:LIKE]->(post:Post)  
            WHERE post.identity = $postIdentity  
            RETURN COUNT(DISTINCT profile) 
            """;

    public static final String FIND_HOW_MANY_PROFILES_DISLIKE_THE_POST_TEMPLATE =
            """
             MATCH (profile:Profile)-[:DISLIKE]->(post:Post)
             WHERE post.identity = $postIdentity
             RETURN COUNT(DISTINCT profile)
             """;

    public static final String FIND_HOW_MANY_PROFILES_STAR_THE_POST_TEMPLATE =
            "MATCH (profile:Profile)-[:STAR]->(post:Post) " +
                    "WHERE post.identity = $postIdentity " +
                    "RETURN COUNT(DISTINCT profile)";

    public static final String FIND_USER_IDENTITIES_WHO_LIKED_THE_POST =
            """
            MATCH (profile:Profile)-[:LIKE]->(post:Post)
            WHERE post.identity = $postIdentity
            RETURN DISTINCT profile.identity
            """;

    public static final String FIND_USER_IDENTITIES_WHO_DISLIKED_THE_POST =
            """
            MATCH (profile:Profile)-[:DISLIKE]->(post:Post)
            WHERE post.identity = $postIdentity
            RETURN DISTINCT profile.identity
            """;

    public static final String FIND_USER_IDENTITIES_WHO_STARED_THE_POST =
            """
            MATCH (profile:Profile)-[:STAR]->(post:Post)
            WHERE post.identity = $postIdentity
            RETURN DISTINCT profile.identity
            """;

    private Queries() {
    }
}
