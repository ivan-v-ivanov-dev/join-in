package com.social.reaction.repository.queries;

public class Queries {

    public static final String FIND_HOW_MANY_PROFILES_LIKE_THE_POST_TEMPLATE =
            "MATCH (p:Profile)-[:LIKE]->(:Post {identity: $postIdentity}) RETURN count(p)";

    public static final String FIND_HOW_MANY_PROFILES_DISLIKE_THE_POST_TEMPLATE =
            "MATCH (p:Profile)-[:DISLIKE]->(:Post {identity: $postIdentity}) RETURN count(p)";

    public static final String FIND_HOW_MANY_PROFILES_STAR_THE_POST_TEMPLATE =
            "MATCH (p:Profile)-[:STAR]->(:Post {identity: $postIdentity}) RETURN count(p)";

    private Queries() {
    }
}
