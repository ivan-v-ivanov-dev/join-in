package com.social.gateway.service.constants;

public class LoggerConstants {

    private static final String KAFKA_MESSAGING = "Kafka Messaging :: ";

    public static final String NEW_REGISTERED_USER_CREATED_AND_SEND_TO_AUTHENTICATION_SERVICE_TOPIC_NAME_USER_IDENTITY_TEMPLATE =
            KAFKA_MESSAGING + "New registered user created and send to Authentication service (Kafka topic: %s, User identity: %s)";

    public static final String USER_LOGGED_TEMPLATE = "User logged: %s";

    public static final String USER_LOGIN_MESSAGE_SEND_TO_MESSAGE_SERVICE_TEMPLATE =
            KAFKA_MESSAGING + "User login send to Message services (Kafka topic: %s, User identity: %s)";

    public static final String USER_LOGOUT_MESSAGE_CREATED_AND_SEND_TO_MESSAGE_SERVICE_TOPIC_NAME_USER_IDENTITY_TEMPLATE =
            KAFKA_MESSAGING + "User logout message created and send to Authentication service (Kafka topic: %s, User identity %s)";

    public static final String USER_RETRIEVED_TEMPLATE = "User %s retrieved";

    public static final String RETRIEVE_PROFILE_IMAGE_FROM_IMAGE_SERVICE_TEMPLATE =
            "Retrieve Profile image from Image Service (Profile identity: %s)";

    public static final String RETRIEVE_PROFILE_BACKGROUND_IMAGE_FROM_IMAGE_SERVICE_TEMPLATE =
            "Retrieve Profile background image from Image Service (Profile identity: %s)";

    private LoggerConstants() {
    }
}
