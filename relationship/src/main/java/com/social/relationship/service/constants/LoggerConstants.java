package com.social.relationship.service.constants;

public class LoggerConstants {

    public static final String NEW_REGISTERED_USER_MESSAGE_RECEIVED_FROM_API_GATEWAY_SERVICE_TEMPLATE =
            "Kafka Messaging :: New registered user received from API Gateway service (Kafka topic: %s, User identity: %s)";

    public static final String NEW_USER_SAVED_IN_DATABASE_TEMPLATE =
            "New user saved in database (User identity: %s)";

    public static final String CREATE_FRIEND_RELATIONSHIP_BETWEEN_SENDER_AND_RECIPIENT_TEMPLATE =
            "Create friend relationship between sender and recipient (Sender identity: %s, Recipient identity: %s)";

    public static final String CREATE_FRIEND_RELATIONSHIP_REQUEST_BETWEEN_SENDER_AND_RECIPIENT_TEMPLATE =
            "Create friend request relationship between sender and recipient (Sender identity: %s, Recipient identity: %s)";

    public static final String RETRIEVE_FRIENDS_IDENTITIES_FOR_USER_TEMPLATE =
            "Retrieve friends identities for user (User identity: %s)";

    private LoggerConstants(){}
}
