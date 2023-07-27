package com.social.relationship.service.constants;

public class LoggerConstants {

    public static final String NEW_USER_MESSAGE_RECEIVED_FROM_AUTHENTICATION_SERVICE_TEMPLATE =
            "Kafka Messaging :: New user message received from Authentication service (Kafka topic: %s, User identity: %s)";

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

    private LoggerConstants() {
    }
}
