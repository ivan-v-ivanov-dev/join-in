package com.social.notification.service.constants;

public class LoggerConstants {

    private static final String KAFKA_MESSAGING = "Kafka Messaging :: ";

    public static final String NEW_USER_MESSAGE_RECEIVED_FROM_AUTHENTICATION_SERVICE_TEMPLATE =
            KAFKA_MESSAGING + "New user message received from Authentication service (Kafka topic: %s, User identity: %s)";

    public static final String NEW_POST_NOTIFICATION_MESSAGE_RECEIVED_FROM_POST_SERVICE_TEMPLATE =
            KAFKA_MESSAGING + "New post notification message received from Post service (Kafka topic: %s)";

    public static final String NEW_COMMENT_NOTIFICATION_MESSAGE_RECEIVED_FROM_POST_SERVICE_TEMPLATE =
            KAFKA_MESSAGING + "New comment notification message received from Post service (Kafka topic: %s)";

    public static final String LIKE_POST_NOTIFICATION_MESSAGE_RECEIVED_FROM_REACTION_SERVICE_TEMPLATE =
            KAFKA_MESSAGING + "LIKE post notification message received from Reaction service (Kafka topic: %s)";

    public static final String NEW_COLLECTION_CREATED_TEMPLATE =
            "New Collection created (Collection name: %s)";

    public static final String NOTIFICATIONS_SAVED_FOR_ALL_RELATED_USERS =
            "Notifications saved for all related users";

    private LoggerConstants(){}
}
