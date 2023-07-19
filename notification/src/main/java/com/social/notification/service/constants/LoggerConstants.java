package com.social.notification.service.constants;

public class LoggerConstants {

    public static final String NEW_USER_MESSAGE_RECEIVED_FROM_AUTHENTICATION_SERVICE_TEMPLATE =
            "Kafka Messaging :: New user message received from Authentication service (Kafka topic: %s, User identity: %s)";

    public static final String NEW_COLLECTION_CREATED_TEMPLATE =
            "New Collection created (Collection name: %s)";

    private LoggerConstants(){}
}
