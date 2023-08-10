package com.social.message.service.constants;

public class LoggerConstants {

    public static final String RETRIEVE_ONLINE_FRIENDS_FOR_USER_TEMPLATE =
            "Retrieve online friends for user (User identity: %s)";

    public static final String SET_USER_ONLINE_TEMPLATE =
            "Set user online (User identity: %s)";

    public static final String SET_USER_OFFLINE_TEMPLATE =
            "Set user offline (User identity: %s)";

    public static final String USER_LOGIN_MESSAGE_RECEIVED_FROM_AUTHENTICATION_SERVICE_TEMPLATE =
            "Kafka Messaging :: User login message received from Authentication service (Kafka topic: %s, User identity: %s)";

    public static final String USER_LOGOUT_MESSAGE_RECEIVED_FROM_PROFILE_SERVICE_TEMPLATE =
            "Kafka Messaging :: User logout message received from Profile service (Kafka topic: %s, User identity: %s)";

    private LoggerConstants() {
    }
}
