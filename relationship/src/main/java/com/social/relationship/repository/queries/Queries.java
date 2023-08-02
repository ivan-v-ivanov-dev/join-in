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

    public static final String DELETE_FRIENDSHIP_REQUEST_RELATIONSHIP_BETWEEN_SENDER_AND_RECIPIENT =
            "MATCH (sender:Profile)-[relationship:FRIENDSHIP_REQUEST]->(recipient:Profile) " +
                    "WHERE sender.identity = $senderUserIdentity AND " +
                    "recipient.identity = $recipientUserIdentity " +
                    "DELETE relationship";

    public static final String CREATE_FRIENDSHIP_RELATIONSHIP_BETWEEN_SENDER_AND_RECIPIENT =
            "MATCH (sender:Profile), (recipient:Profile) " +
                    "WHERE sender.identity = $senderUserIdentity AND " +
                    "recipient.identity = $recipientUserIdentity " +
                    "MERGE (sender)-[:FRIEND]->(recipient)";

    public static final String DELETE_FRIEND_RELATIONSHIP_BETWEEN_SENDER_AND_RECIPIENT =
            "MATCH (sender:Profile)-[relationship:FRIEND]->(recipient:Profile) " +
                    "WHERE sender.identity = $senderUserIdentity AND " +
                    "recipient.identity = $recipientUserIdentity " +
                    "DELETE relationship";

    public static final String FIND_TEN_FRIEND_SUGGESTIONS =
            "MATCH (profile:Profile), (currentProfile: Profile) " +
                    "WHERE currentProfile.identity = %currentUserIdentity AND " +
                    "NOT EXISTS((profile)-[:FRIEND]->(currentProfile)) AND " +
                    "NOT EXISTS((profile)-[:FRIENDSHIP_REQUEST]->(currentProfile)) AND " +
                    "profile.identity <> $currentUserIdentity " +
                    "RETURN DISTINCT profile.identity " +
                    "LIMIT 10";

    private Queries() {
    }
}
