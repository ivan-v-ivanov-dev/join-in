package com.social.post.service.constants;

public class LoggerConstants {

    // Kafka received messages
    private static final String KAFKA_MESSAGING = "Kafka Messaging :: ";

    public static final String NEW_PUBLISHED_POST_MESSAGE_RECEIVED__TOPIC_NAME_AUTHOR_IDENTITY_TEMPLATE =
            KAFKA_MESSAGING +  "New post published message received (Kafka topic: %s, Post user: %s)";

    public static final String NEW_PUBLISHED_COMMENT_MESSAGE_RECEIVED_TOPIC_NAME_AUTHOR_IDENTITY_TEMPLATE =
            KAFKA_MESSAGING +  "New comment published message received (Kafka topic: %s, Comment user %s)";

    public static final String NEW_DELETE_POST_MESSAGE_RECEIVED_TOPIC_NAME_POST_IDENTITY_TEMPLATE =
            KAFKA_MESSAGING +  "New delete post message received (Kafka topic: %s, Post identity: %s)";

    public static final String NEW_EDIT_POST_MESSAGE_RECEIVED_TOPIC_NAME_POST_IDENTITY_TEMPLATE =
            KAFKA_MESSAGING +  "New edit post message received (Kafka topic: %s, Post identity: %s)";

    public static final String NEW_USER_MESSAGE_RECEIVED_FROM_AUTHENTICATION_SERVICE_TEMPLATE =
            KAFKA_MESSAGING +  "New user message received from Authentication service (Kafka topic: %s, User identity: %s)";

    public static final String NEW_POST_NOTIFICATIONS_MESSAGE_SEND_TO_NOTIFICATION_SERVICE =
            KAFKA_MESSAGING +  "New post notification received send to Notification service (Kafka topic: %s)";

    // Post create
    public static final String NEW_POST_SAVED_IN_DATABASE_AUTHOR_IDENTITY_POST_IDENTITY_TEMPLATE =
            "New Post saved in database (User identity %s, Post identity: %s)";

    public static final String NEW_COLLECTION_SAVED_IN_DATABASE_TEMPLATE =
            "New collection created (Collection: %s)";

    public static final String RETRIEVE_ALL_FRIENDS_FROM_RELATIONSHIP_SERVICE_TEMPLATE =
            "Retrieve all friends from Relationship service (User identity: %s)";

    private LoggerConstants() {
    }
}
