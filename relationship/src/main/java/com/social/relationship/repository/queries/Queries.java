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

    private Queries() {
    }
}
