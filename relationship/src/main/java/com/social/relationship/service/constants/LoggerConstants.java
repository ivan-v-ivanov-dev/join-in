package com.social.relationship.service.constants;

public class LoggerConstants {

    private static final String KAFKA_MESSAGING = "Kafka Messaging :: ";

    public static final String NEW_USER_MESSAGE_RECEIVED_FROM_AUTHENTICATION_SERVICE_TEMPLATE =
            KAFKA_MESSAGING + "New user message received from Authentication service (Kafka topic: %s, User identity: %s)";

    public static final String ACCEPT_FRIENDSHIP_MESSAGE_RECEIVED_FROM_PROFILE_SERVICE_TEMPLATE =
            KAFKA_MESSAGING + "Accept friendship message received from Profile service (Kafka topic: %s, Accepting user identity: %s)";

    public static final String DECLINE_FRIENDSHIP_MESSAGE_RECEIVED_FROM_PROFILE_SERVICE_TEMPLATE =
            KAFKA_MESSAGING + "Decline friendship message received from Profile service (Kafka topic: %s, Declining user identity: %s)";

    public static final String UNFRIEND_USER_MESSAGE_RECEIVED_FROM_PROFILE_SERVICE_TEMPLATE =
            KAFKA_MESSAGING + "Unfriend user message received from Profile service (Kafka topic: %s, Unfriend user identity: %s)";

    public static final String NEW_USER_SAVED_IN_DATABASE_TEMPLATE =
            "New user saved in database (User identity: %s)";

    public static final String RETRIEVE_FRIENDS_IDENTITIES_FOR_USER_TEMPLATE =
            "Retrieve friends identities for user (User identity: %s)";

    public static final String RETRIEVE_FRIENDS_PROFILE_IMAGES_FOR_USER_TEMPLATE =
            "Retrieve friends profile images for user (User identity: %s)";

    public static final String RETRIEVE_FRIENDSHIP_REQUESTS_FOR_USER_TEMPLATE =
            "Retrieve friendship requests for user (User identity: %s)";

    public static final String RETRIEVE_FRIENDS_COUNT_FOR_USER_TEMPLATE =
            "Retrieve friends count for user (User identity: %s)";

    public static final String RETRIEVE_FRIENDSHIP_REQUESTS_COUNT_FOR_USER_TEMPLATE =
            "Retrieve friendship requests count for user (User identity: %s)";

    public static final String DELETE_FRIENDSHIP_REQUESTS_RELATIONSHIP_BETWEEN_SENDER_AND_RECIPIENT_TEMPLATE =
            "Delete friendship request relationship between sender and recipient (Sender identity: %s, Recipient identity: %s)";

    public static final String CREATE_FRIEND_RELATIONSHIP_BETWEEN_SENDER_AND_RECIPIENT_TEMPLATE =
            "Create friend relationship between sender and recipient (Sender identity: %s, Recipient identity: %s)";

    public static final String DELETE_FRIEND_RELATIONSHIP_FOR_BOTH_USERS_TEMPLATE =
            "Delete friend relationship for both users (Sender identity: %s, Recipient identity: %s)";

    public static final String RETRIEVE_FRIEND_SUGGESTIONS_TEMPLATE =
            "Retrieve friend suggestions for user (User identity: %s)";

    private LoggerConstants() {
    }
}
