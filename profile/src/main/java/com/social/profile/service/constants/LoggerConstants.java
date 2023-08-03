package com.social.profile.service.constants;

public class LoggerConstants {

    private static final String KAFKA_MESSAGING = "Kafka Messaging :: ";

    public static final String NEW_REGISTERED_USER_CREATED_AND_SEND_TO_AUTHENTICATION_SERVICE_TOPIC_NAME_USER_IDENTITY_TEMPLATE =
            KAFKA_MESSAGING + "New registered user created and send to Authentication service (Kafka topic: %s, User identity: %s)";

    public static final String NEW_POST_CREATED_AND_SEND_TO_POST_SERVICE_TOPIC_NAME_USER_IDENTITY_TEMPLATE =
            KAFKA_MESSAGING + "New post created and send to Post service (Kafka topic: %s, Post created by user %s)";

    public static final String NEW_COMMENT_CREATED_AND_SEND_TO_POST_SERVICE_TOPIC_NAME_USER_IDENTITY_TEMPLATE =
            KAFKA_MESSAGING + "New comment created and send to Post service (Kafka topic: %s, Comment created by user %s)";

    public static final String DELETE_POST_CREATED_AND_SEND_TO_POST_SERVICE_TOPIC_NAME_POST_IDENTITY_TEMPLATE =
            KAFKA_MESSAGING + "Delete post message created and send to Post service (Kafka topic: %s, Post identity %s)";

    public static final String EDIT_POST_CREATED_AND_SEND_TO_POST_SERVICE_TOPIC_NAME_POST_IDENTITY_TEMPLATE =
            KAFKA_MESSAGING + "Edit post message created and send to Post service (Kafka topic: %s, Post identity %s)";

    public static final String LIKE_POST_MESSAGE_CREATED_AND_SEND_TO_REACTION_SERVICE_TOPIC_NAME_POST_IDENTITY_TEMPLATE =
            KAFKA_MESSAGING + "LIKE post message created and send to Reaction service (Kafka topic: %s, Post identity %s)";

    public static final String DISLIKE_POST_MESSAGE_CREATED_AND_SEND_TO_REACTION_SERVICE_TOPIC_NAME_POST_IDENTITY_TEMPLATE =
            KAFKA_MESSAGING + "DISLIKE post message created and send to Reaction service (Kafka topic: %s, Post identity %s)";

    public static final String STAR_POST_MESSAGE_CREATED_AND_SEND_TO_REACTION_SERVICE_TOPIC_NAME_POST_IDENTITY_TEMPLATE =
            KAFKA_MESSAGING + "STAR post message created and send to Reaction service (Kafka topic: %s, Post identity %s)";

    public static final String ACCEPT_FRIENDSHIP_MESSAGE_CREATED_AND_SEND_TO_RELATIONSHIP_SERVICE_TOPIC_NAME_RECIPIENT_IDENTITY_TEMPLATE =
            KAFKA_MESSAGING + "Accept friendship message created and send to Relationship service (Kafka topic: %s, Recipient user identity %s)";

    public static final String DECLINE_FRIENDSHIP_MESSAGE_CREATED_AND_SEND_TO_RELATIONSHIP_SERVICE_TOPIC_NAME_RECIPIENT_IDENTITY_TEMPLATE =
            KAFKA_MESSAGING + "Decline friendship message created and send to Relationship service (Kafka topic: %s, Recipient user identity %s)";

    public static final String UNFRIEND_MESSAGE_CREATED_AND_SEND_TO_RELATIONSHIP_SERVICE_TOPIC_NAME_RECIPIENT_IDENTITY_TEMPLATE =
            KAFKA_MESSAGING + "Unfriend message created and send to Relationship service (Kafka topic: %s, Recipient user identity %s)";

    public static final String LIKE_COMMENT_MESSAGE_CREATED_AND_SEND_TO_REACTION_SERVICE_TOPIC_NAME_COMMENT_IDENTITY_TEMPLATE =
            KAFKA_MESSAGING + "LIKE comment message created and send to Reaction service (Kafka topic: %s, Comment identity %s)";

    public static final String DISLIKE_COMMENT_MESSAGE_CREATED_AND_SEND_TO_REACTION_SERVICE_TOPIC_NAME_COMMENT_IDENTITY_TEMPLATE =
            KAFKA_MESSAGING + "DISLIKE comment message created and send to Reaction service (Kafka topic: %s, Comment identity %s)";

    public static final String NEW_REGISTERED_USER_PROFILE_SAVED_IN_DATABASE_TEMPLATE =
            "New registered user saved in database (User identity: %s)";

    public static final String RETRIEVE_PROFILE_IMAGE_FROM_IMAGE_SERVICE_TEMPLATE =
            "Retrieve Profile image from Image Service (Profile identity: %s)";

    public static final String RETRIEVE_PROFILE_BACKGROUND_IMAGE_FROM_IMAGE_SERVICE_TEMPLATE =
            "Retrieve Profile background image from Image Service (Profile identity: %s)";

    public static final String RETRIEVE_PROFILE_ALBUM_IMAGES_FROM_IMAGE_SERVICE_TEMPLATE =
            "Retrieve Profile album images from Image Service (Profile identity: %s)";

    public static final String RETRIEVE_ALL_FRIENDS_FROM_RELATION_SERVICE_TEMPLATE =
            "Retrieve all friends from Relation service (Profile identity: %s)";

    public static final String RETRIEVE_FRIENDS_COUNT_FROM_RELATION_SERVICE_TEMPLATE =
            "Retrieve friends count from Relation service (Profile identity: %s)";

    public static final String RETRIEVE_FRIENDSHIP_REQUESTS_FROM_RELATION_SERVICE_TEMPLATE =
            "Retrieve friendship requests from Relation service (Profile identity: %s)";

    public static final String RETRIEVE_POST_TEMPLATE =
            "Retrieve post (Post identity: %s)";

    public static final String RETRIEVE_USER_POSTS_FROM_POST_SERVICE_TEMPLATE =
            "Retrieve user posts from Post service (User identity: %s)";

    public static final String RETRIEVE_USERS_FEED_POSTS_FROM_POST_SERVICE_TEMPLATE =
            "Retrieve user's feed posts from Post service (User identity: %s)";

    public static final String RETRIEVE_PROFILE_TEMPLATE =
            "Retrieve Profile (User identity: %s)";

    public static final String RETRIEVE_PROFILE_NAMES =
            "Retrieve Profile names (User identity: %s)";

    public static final String RETRIEVE_FRIENDSHIP_REQUEST_COUNT_FROM_RELATION_SERVICE_TEMPLATE =
            "Retrieve friendship request count from Relation service (Profile identity: %s)";

    public static final String RETRIEVE_USER_NOTIFICATIONS_FROM_NOTIFICATION_SERVICE_TEMPLATE =
            "Retrieve user notifications from Notification service (Profile identity: %s)";

    public static final String RETRIEVE_FRIEND_SUGGESTIONS_FROM_RELATIONSHIP_SERVICE_TEMPLATE =
            "Retrieve friend suggestions for user from Relationship service (User identity: %s)";

    private LoggerConstants() {
    }
}
