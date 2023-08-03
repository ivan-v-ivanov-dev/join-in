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

    public static final String NEW_POST_NOTIFICATIONS_MESSAGE_SEND_TO_NOTIFICATION_SERVICE_TEMPLATE =
            KAFKA_MESSAGING +  "New post notification send to Notification service (Kafka topic: %s)";

    public static final String NEW_COMMENT_NOTIFICATIONS_MESSAGE_SEND_TO_NOTIFICATION_SERVICE_TEMPLATE =
            KAFKA_MESSAGING +  "New comment notification send to Notification service (Kafka topic: %s)";

    public static final String NEW_POST_NODE_MESSAGE_SEND_TO_REACTION_SERVICE_TEMPLATE =
            KAFKA_MESSAGING +  "New post node send to Reaction service (Kafka topic: %s)";

    public static final String NEW_COMMENT_NODE_MESSAGE_SEND_TO_REACTION_SERVICE_TEMPLATE =
            KAFKA_MESSAGING +  "New comment node send to Reaction service (Kafka topic: %s)";

    public static final String DELETE_NODES_MESSAGE_SEND_TO_REACTION_SERVICE_TEMPLATE =
            KAFKA_MESSAGING +  "Delete nodes send to Reaction service (Kafka topic: %s)";

    // Post and Comment
    public static final String NEW_POST_SAVED_IN_DATABASE_AUTHOR_IDENTITY_POST_IDENTITY_TEMPLATE =
            "New Post saved in database (User identity %s, Post identity: %s)";

    public static final String NEW_COLLECTION_SAVED_IN_DATABASE_TEMPLATE =
            "New collection created (Collection: %s)";

    public static final String RETRIEVE_ALL_FRIENDS_IDENTITIES_FROM_RELATIONSHIP_SERVICE_TEMPLATE =
            "Retrieve all friends identities from Relationship service (User identity: %s)";

    public static final String NEW_COMMENT_SAVED_IN_DATABASE_AUTHOR_IDENTITY_COMMENT_IDENTITY_TEMPLATE =
            "New Comment saved in database (User identity %s, Comment identity: %s)";

    public static final String RETRIEVE_ALL_USERS_WHO_REACTED_AND_COMMENTED_THE_POST_TEMPLATE =
            "Retrieve all users who reacted and commented the Post (Post identity: %s)";

    public static final String RETRIEVE_POST_TEMPLATE =
            "Retrieve Post (Post identity: %s)";

    public static final String RETRIEVE_POSTS_FOR_USER_TEMPLATE =
            "Retrieve Posts for user (User identity: %s)";

    public static final String DELETE_POST_TEMPLATE =
            "Delete Post (Post identity: %s)";

    public static final String UPDATE_POST_CONTENT_TEMPLATE =
            "Update Post content (Post identity: %s)";

    public static final String RETRIEVE_AUTHOR_POSTS_COUNT_TEMPLATE =
            "Retrieve author posts count (Author identity: %s)";

    public static final String RETRIEVE_COMMENT_IDENTITIES_FOR_A_POST_TEMPLATE =
            "Retrieve comment identities for a post (Post identity: %s)";

    public static final String RETRIEVE_USERS_FEED_POSTS_TEMPLATE =
            "Retrieve user's feed posts (User identity: %s)";

    private LoggerConstants() {
    }
}
