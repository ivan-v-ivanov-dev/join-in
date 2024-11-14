package com.social.relationship.repository.queries;

public class Queries {

    public static final String CREATE_FRIENDSHIP_RELATIONSHIP_BETWEEN_SENDER_AND_RECIPIENT =
            "MATCH (sender:Profile), (recipient:Profile) " +
                    "WHERE sender.identity = $senderUserIdentity AND " +
                    "recipient.identity = $recipientUserIdentity " +
                    "MERGE (sender)-[:FRIEND]->(recipient)";

    public static final String CREATE_FRIENDSHIP_REQUEST_RELATIONSHIP_BETWEEN_SENDER_AND_RECIPIENT =
            "MATCH (sender:Profile), (recipient:Profile) " +
                    "WHERE sender.identity = $senderUserIdentity AND " +
                    "recipient.identity = $recipientUserIdentity " +
                    "MERGE (sender)-[:FRIENDSHIP_REQUEST]->(recipient)";

    public static final String FIND_THE_FRIENDS_FOR_A_PROFILE_BY_PROFILE_IDENTITY_TEMPLATE =
            """
            MATCH (profile:Profile)-[:FRIEND]->(friend:Profile)
            WHERE profile.identity = $identity
            RETURN DISTINCT friend.identity
            """;

    public static final String FIND_FRIENDSHIP_REQUESTS_FOR_A_PROFILE_BY_PROFILE_IDENTITY_TEMPLATE =
            """
            MATCH (friendship_request:Profile)-[:FRIENDSHIP_REQUEST]->(profile:Profile)
            WHERE profile.identity = $identity
            RETURN DISTINCT friendship_request.identity
            """;

    public static final String FIND_FRIENDS_COUNT_FOR_A_PROFILE_TEMPLATE =
            """
            MATCH (profile:Profile)-[:FRIEND]->() 
            WHERE profile.identity = $identity 
            RETURN count(profile)
            """;


    private Queries() {
    }
}
