package com.social.model.service.constants;

public class LoggerConstants {

    public static final String NEW_USER_MESSAGE_RECEIVED_FROM_AUTHENTICATION_SERVICE_TEMPLATE =
            "Kafka Messaging :: New user message received from Authentication service (Kafka topic: %s, User identity: %s)";

    public static final String NEW_COLLECTION_CREATED_TEMPLATE =
            "New Collection created (Collection name: %s)";

    public static final String RETRIEVE_PROFILE_IMAGE_FOR_USER_TEMPLATE =
            "Retrieve profile image for user (User identity: %s)";

    public static final String RETRIEVE_BACKGROUND_IMAGE_FOR_USER_TEMPLATE =
            "Retrieve background image for user (User identity: %s)";

    public static final String RETRIEVE_ALBUM_IMAGES_FOR_USER_TEMPLATE =
            "Retrieve album images for user (User identity: %s)";

    private LoggerConstants(){}
}
