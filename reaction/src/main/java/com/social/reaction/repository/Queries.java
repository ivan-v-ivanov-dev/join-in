package com.social.reaction.repository;

public class Queries {

    public static final String FIND_HOW_MANY_PROFILES_LIKE_THE_POST_TEMPLATE =
            "MATCH (p:Profile)-[:LIKE]->(:Post {identity: $postIdentity}) RETURN count(p)";

    private Queries() {
    }
}
