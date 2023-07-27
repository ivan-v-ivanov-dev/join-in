package com.social.relationship.repository.queries;

public class Queries {

    public static final String FIND_THE_FRIENDS_FOR_A_PROFILE_BY_PROFILE_IDENTITY_TEMPLATE =
            "MATCH (profile:Profile)-[:FRIEND]->(friend:Profile) " +
                    "WHERE profile.identity = $identity " +
                    "RETURN DISTINCT friend.identity";

    public static final String FIND_HOW_MANY_FRIENDS_HAS_A_PROFILE_TEMPLATE =
            "MATCH (profile:Profile)-[:FRIEND]->() " +
                    "WHERE profile.identity = $identity " +
                    "RETURN count(profile)";

    public static final String FIND_THE_FRIENDSHIP_REQUESTS_FOR_A_PROFILE_BY_PROFILE_IDENTITY_TEMPLATE =
            "MATCH (friendship_request:Profile)-[:FRIENDSHIP_REQUEST]->(profile:Profile) " +
                    "WHERE profile.identity = $identity " +
                    "RETURN DISTINCT friendship_request.identity";

    public static final String FIND_HOW_MANY_FRIENDSHIP_REQUESTS_HAS_A_PROFILE_TEMPLATE =
            "MATCH (friendship_request:Profile)-[:FRIENDSHIP_REQUEST]->(profile:Profile) " +
                    "WHERE profile.identity = $identity " +
                    "RETURN COUNT(DISTINCT friendship_request)";

    private Queries() {
    }
}
