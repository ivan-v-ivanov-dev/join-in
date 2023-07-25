package com.social.reaction.service.constants;

public class LoggerConstants {

    public static final String NEW_USER_MESSAGE_RECEIVED_FROM_AUTHENTICATION_SERVICE_TEMPLATE =
            "Kafka Messaging :: New user message received from Authentication service (Kafka topic: %s, User identity: %s)";

    public static final String NEW_POST_NODE_RECEIVED_FROM_POST_SERVICE_TEMPLATE =
            "Kafka Messaging :: New post message received from Post service (Kafka topic: %s, Post identity: %s)";

    public static final String NEW_COMMENT_NODE_RECEIVED_FROM_POST_SERVICE_TEMPLATE =
            "Kafka Messaging :: New comment message received from Post service (Kafka topic: %s, Comment identity: %s)";

    public static final String NEW_USER_SAVED_IN_DATABASE_TEMPLATE =
            "New user saved in database (User identity: %s)";

    public static final String RETRIEVE_USERS_WHO_REACTED_TO_POST_TEMPLATE =
            "Retrieve users identities who reacted to post (Post identity: %s)";

    public static final String SAVE_POST_IN_DATABASE_TEMPLATE = "Save post in database (Post identity: %s)";

    public static final String SAVE_COMMENT_IN_DATABASE_TEMPLATE = "Save comment in database (Comment identity: %s)";

    private LoggerConstants() {
    }
}
