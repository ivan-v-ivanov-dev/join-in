package com.social.relationship.repository.queries;

public class Queries {

    public static final String FIND_THE_FRIENDS_FOR_A_PROFILE_BY_PROFILE_IDENTITY_TEMPLATE =
            "MATCH (p:Profile)-[:FRIEND]->(friend:Profile) WHERE p.identity = $identity RETURN DISTINCT friend.identity";

    public static final String FIND_HOW_MANY_FRIENDS_HAS_A_PROFILE_TEMPLATE =
            "MATCH (p:Profile)-[:FRIEND]->() WHERE p.identity = $identity RETURN count(p)";

    private Queries() {
    }
}
