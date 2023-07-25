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

    public static final String LIKE_POST_CREATED_AND_SEND_TO_REACTION_SERVICE_TOPIC_NAME_POST_IDENTITY_TEMPLATE =
            KAFKA_MESSAGING + "Like post message created and send to Reaction service (Kafka topic: %s, Post identity %s)";

    public static final String NEW_REGISTERED_USER_PROFILE_SAVED_IN_DATABASE_TEMPLATE =
            "New registered user saved in database (User identity: %s)";

    public static final String RETRIEVE_PROFILE_IMAGE_FROM_IMAGE_SERVICE_TEMPLATE =
            "Retrieve Profile image from Image Service (Profile identity: %s)";

    public static final String RETRIEVE_PROFILE_BACKGROUND_IMAGE_FROM_IMAGE_SERVICE_TEMPLATE =
            "Retrieve Profile background image from Image Service (Profile identity: %s)";

    public static final String RETRIEVE_PROFILE_ALBUM_IMAGES_FROM_IMAGE_SERVICE_TEMPLATE =
            "Retrieve Profile album images from Image Service (Profile identity: %s)";

    public static final String RETRIEVE_ALL_FRIENDS_FOR_PROFILE_TEMPLATE =
            "Retrieve all friends (Profile identity: %s)";


    private LoggerConstants() {
    }
}
