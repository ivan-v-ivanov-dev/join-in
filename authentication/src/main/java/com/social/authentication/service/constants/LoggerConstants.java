package com.social.authentication.service.constants;

public class LoggerConstants {

    public static final String FAILED_TO_AUTHENTICATE_WITH_CREDENTIALS =
            "Failed to Authenticate with input credentials";

    public static final String USER_WITH_IDENTITY_LOGGED_TEMPLATE =
            "User with identity %s logged";

    public static final String USER_WITH_IDENTITY_LOGIN_SAVED_IN_DATABASE_TEMPLATE =
            "User with identity %s login saved in database";

    public static final String NEW_REGISTERED_USER_SAVED_IN_DATABASE_TEMPLATE =
            "New registered user (User identity: %s) saved in database";

    public static final String NEW_REGISTERED_USER_MESSAGE_RECEIVED_FROM_PROFILE_SERVICE_TEMPLATE =
            "Kafka Messaging :: New registered user received from Profile service (Kafka topic: %s, User identity: %s)";

    public static final String NEW_USER_MESSAGE_SEND_TO_MULTIPLE_SERVICES_TEMPLATE =
            "Kafka Messaging :: New user send to multiple services (Kafka topic: %s, User identity: %s)";

    public static final String USER_LOGIN_MESSAGE_SEND_TO_MESSAGE_SERVICE_TEMPLATE =
            "Kafka Messaging :: User login send to Message services (Kafka topic: %s, User identity: %s)";

    private LoggerConstants() {
    }
}
