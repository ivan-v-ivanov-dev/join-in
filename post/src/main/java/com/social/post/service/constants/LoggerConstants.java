package com.social.post.service.constants;

public class LoggerConstants {

    // Kafka Received Messages
    public static final String NEW_POST_PUBLISHED_MESSAGE_RECEIVED_FROM_PROFILE_SERVICE_TEMPLATE =
            "Kafka Message for new publication posted by User %s received from Profile service (Kafka topic: %s)";

    public static final String NEW_COMMENT_PUBLISHED_MESSAGE_RECEIVED_FROM_PROFILE_SERVICE_TEMPLATE =
            "Kafka Message for new comment posted by User %s received from Profile service (Kafka topic: %s)";

    public static final String NEW_DELETE_POST_MESSAGE_RECEIVED_FROM_PROFILE_SERVICE_TEMPLATE =
            "Kafka Message for post deleting Post %s received from Profile service (Kafka topic: %s)";

    // Post create
    public static final String NEW_POST_SAVED_IN_DATABASE_TEMPLATE =
            "New Post saved in database (User identity %s, Post identity: %s)";

    private LoggerConstants() {
    }
}
