package com.social.relationship.service.constants;

public class LoggerConstants {

    public static final String NEW_USER_MESSAGE_RECEIVED_FROM_AUTHENTICATION_SERVICE_TEMPLATE =
            "Kafka Messaging :: New user message received from Authentication service (Kafka topic: %s, User identity: %s)";

    public static final String NEW_USER_SAVED_IN_DATABASE_TEMPLATE =
            "New user saved in database (User identity: %s)";

    private LoggerConstants() {
    }
}
