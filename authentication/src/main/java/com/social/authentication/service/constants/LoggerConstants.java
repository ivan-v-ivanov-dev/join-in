package com.social.authentication.service.constants;

public class LoggerConstants {

    public static final String FAILED_TO_AUTHENTICATE_WITH_CREDENTIALS = "Failed to Authenticate with input credentials";
    public static final String USER_WITH_IDENTITY_LOGGED_TEMPLATE = "User with identity %s logged";
    public static final String USER_WITH_IDENTITY_LOGIN_SAVED_IN_DATABASE_TEMPLATE = "User with identity %s login saved in database";
    public static final String REDIRECTING_TO_PROFILE_SERVICE = "Redirecting to Profile service";
    public static final String CAN_NOT_REDIRECT_TO_PROFILE_SERVICE_TEMPLATE = "Can't redirect to profile service:: %s";
    public static final String NEW_REGISTERED_USER_SAVED_IN_DATABASE_TEMPLATE =
            "New registered user (User identity: %s) saved in database";
    public static final String NEW_REGISTERED_USER_MESSAGE_SEND_TO_PROFILE_SERVICE_TEMPLATE =
            "Kafka Message for new registered user (User identity: %s) send to Profile service (Kafka topic: %s)";

    private LoggerConstants() {
    }
}
