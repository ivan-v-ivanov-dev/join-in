package com.social.profile.service.constants;

public class LoggerConstants {

    public static final String KAFKA_MESSAGE_FOR_NEW_REGISTERED_USER_RECEIVED_FROM_AUTHENTICATION_SERVICE_IN_TOPIC_TEMPLATE =
            "Kafka Message for new registered user (User identity: %s) received from Authentication service (Kafka topic: %s)";
    public static final String NEW_REGISTERED_USER_SAVED_IN_DATABASE_TEMPLATE =
            "New registered user (User identity: %s) saved in database";

    private LoggerConstants() {
    }
}
