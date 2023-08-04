package com.social.reaction.service.constants;

public class LoggerConstants {

    private static final String KAFKA_MESSAGING = "Kafka Messaging :: ";

    public static final String NEW_USER_MESSAGE_RECEIVED_FROM_AUTHENTICATION_SERVICE_TEMPLATE =
            KAFKA_MESSAGING + "New user message received from Authentication service (Kafka topic: %s, User identity: %s)";

    public static final String NEW_POST_NODE_RECEIVED_FROM_POST_SERVICE_TEMPLATE =
            KAFKA_MESSAGING + "New post message received from Post service (Kafka topic: %s, Post identity: %s)";

    public static final String NEW_COMMENT_NODE_RECEIVED_FROM_POST_SERVICE_TEMPLATE =
            KAFKA_MESSAGING + "New comment message received from Post service (Kafka topic: %s, Comment identity: %s)";

    public static final String DELETE_NODES_RECEIVED_FROM_POST_SERVICE_TEMPLATE =
            KAFKA_MESSAGING + "Delete nodes received from Post service (Kafka topic: %s)";

    public static final String LIKE_POST_RECEIVED_FROM_PROFILE_SERVICE_TEMPLATE =
            KAFKA_MESSAGING + "LIKE post message received from Profile service (Kafka topic: %s, Post identity: %s)";

    public static final String DISLIKE_POST_RECEIVED_FROM_PROFILE_SERVICE_TEMPLATE =
            KAFKA_MESSAGING + "DISLIKE post message received from Profile service (Kafka topic: %s, Post identity: %s)";

    public static final String STAR_POST_RECEIVED_FROM_PROFILE_SERVICE_TEMPLATE =
            KAFKA_MESSAGING + "STAR post message received from Profile service (Kafka topic: %s, Post identity: %s)";

    public static final String LIKE_POST_NOTIFICATIONS_MESSAGE_SEND_TO_NOTIFICATION_SERVICE_TEMPLATE =
            KAFKA_MESSAGING + "LIKE post message send to Notification service (Kafka topic: %s)";

    public static final String STAR_POST_NOTIFICATIONS_MESSAGE_SEND_TO_NOTIFICATION_SERVICE_TEMPLATE =
            KAFKA_MESSAGING + "STAR post message send to Notification service (Kafka topic: %s)";

    public static final String LIKE_COMMENT_NOTIFICATION_MESSAGE_SEND_TO_NOTIFICATION_SERVICE_TEMPLATE =
            KAFKA_MESSAGING + "LIKE comment message send to Notification service (Kafka topic: %s)";

    public static final String DISLIKE_COMMENT_NOTIFICATION_MESSAGE_SEND_TO_NOTIFICATION_SERVICE_TEMPLATE =
            KAFKA_MESSAGING + "DISLIKE comment message send to Notification service (Kafka topic: %s)";

    public static final String LIKE_COMMENT_RECEIVED_FROM_PROFILE_SERVICE_TEMPLATE =
            KAFKA_MESSAGING + "LIKE comment message received from Profile service (Kafka topic: %s, Comment identity: %s)";

    public static final String DISLIKE_COMMENT_RECEIVED_FROM_PROFILE_SERVICE_TEMPLATE =
            KAFKA_MESSAGING + "DISLIKE comment message received from Profile service (Kafka topic: %s, Comment identity: %s)";

    public static final String NEW_USER_SAVED_IN_DATABASE_TEMPLATE =
            "New user saved in database (User identity: %s)";

    public static final String RETRIEVE_USERS_WHO_REACTED_TO_POST_TEMPLATE =
            "Retrieve users identities who reacted to post (Post identity: %s)";

    public static final String RETRIEVE_USERS_WHO_LIKED_THE_POST_TEMPLATE =
            "Retrieve users identities who liked the post (Post identity: %s)";

    public static final String RETRIEVE_USERS_WHO_DISLIKED_THE_POST_TEMPLATE =
            "Retrieve users identities who disliked the post (Post identity: %s)";

    public static final String RETRIEVE_USERS_WHO_STARED_THE_POST_TEMPLATE =
            "Retrieve users identities who stared the post (Post identity: %s)";

    public static final String RETRIEVE_LIKES_A_POST_USER_COUNT_POST_TEMPLATE =
            "Retrieve likes a post users count (Post identity: %s)";

    public static final String RETRIEVE_DISLIKES_A_POST_USER_COUNT_POST_TEMPLATE =
            "Retrieve dislikes a post users count (Post identity: %s)";

    public static final String RETRIEVE_STARS_A_POST_USER_COUNT_POST_TEMPLATE =
            "Retrieve start a post users count (Post identity: %s)";

    public static final String RETRIEVE_LIKES_A_COMMENT_USER_COUNT_COMMENT_TEMPLATE =
            "Retrieve likes a comment users count (Comment identity: %s)";

    public static final String RETRIEVE_DISLIKES_A_COMMENT_USER_COUNT_COMMENT_TEMPLATE =
            "Retrieve dislikes a comment users count (Comment identity: %s)";

    public static final String SAVE_POST_IN_DATABASE_TEMPLATE = "Save post in database (Post identity: %s)";

    public static final String SAVE_COMMENT_IN_DATABASE_TEMPLATE = "Save comment in database (Comment identity: %s)";

    public static final String COMMENT_NODES_DELETED = "Comment nodes deleted with their relations";

    public static final String POST_NODE_DELETED = "Post node deleted with its relations";

    public static final String DELETE_PREVIOUS_POSSIBLE_REACTIONS_TO_THE_POST_TEMPLATE =
            "Delete previous possible reactions (User identity: %s, Post identity: %s)";

    public static final String POST_LIKED_BY_USER_TEMPLATE = "Post liked by user (User identity: %s, Post identity: %s)";

    public static final String POST_DISLIKED_BY_USER_TEMPLATE = "Post disliked by user (User identity: %s, Post identity: %s)";

    public static final String POST_STARED_BY_USER_TEMPLATE = "Post stared by user (User identity: %s, Post identity: %s)";

    public static final String DELETE_PREVIOUS_POSSIBLE_REACTIONS_TO_THE_COMMENT_TEMPLATE =
            "Delete previous possible reactions (User identity: %s, Comment identity: %s)";

    public static final String COMMENT_LIKED_BY_USER_TEMPLATE = "Comment liked by user (User identity: %s, Comment identity: %s)";

    public static final String COMMENT_DISLIKED_BY_USER_TEMPLATE = "Comment disliked by user (User identity: %s, Comment identity: %s)";

    private LoggerConstants() {
    }
}
