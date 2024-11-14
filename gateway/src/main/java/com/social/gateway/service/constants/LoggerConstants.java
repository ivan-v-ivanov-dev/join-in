package com.social.gateway.service.constants;

public class LoggerConstants {

    private static final String KAFKA_MESSAGING = "Kafka Messaging :: ";

    public static final String NEW_REGISTERED_USER_CREATED_AND_SEND_TO_AUTHENTICATION_SERVICE_TOPIC_NAME_USER_IDENTITY_TEMPLATE =
            KAFKA_MESSAGING + "New registered user created and send to Authentication service (Kafka topic: %s, User identity: %s)";

    public static final String USER_LOGGED_TEMPLATE = "User logged: %s";

    public static final String USER_LOGIN_MESSAGE_SEND_TO_MESSAGE_SERVICE_TEMPLATE =
            KAFKA_MESSAGING + "User login send to Message services (Kafka topic: %s, User identity: %s)";

    public static final String USER_LOGOUT_MESSAGE_CREATED_AND_SEND_TO_MESSAGE_SERVICE_TOPIC_NAME_USER_IDENTITY_TEMPLATE =
            KAFKA_MESSAGING + "User logout message created and send to Authentication service (Kafka topic: %s, User identity %s)";

    public static final String USER_RETRIEVED_TEMPLATE = "User %s retrieved";

    public static final String RETRIEVE_PROFILE_IMAGE_FROM_IMAGE_SERVICE_TEMPLATE =
            "Retrieve Profile image from Image Service (Profile identity: %s)";

    public static final String RETRIEVE_PROFILE_NAMES_FROM_PROFILE_SERVICE_TEMPLATE =
            "Retrieve Profile names from Profile Service (Profile identity: %s)";

    public static final String RETRIEVE_PROFILE_BACKGROUND_IMAGE_FROM_IMAGE_SERVICE_TEMPLATE =
            "Retrieve Profile background image from Image Service (Profile identity: %s)";

    public static final String RETRIEVE_ALBUM_IMAGES_FOR_USER_TEMPLATE =
            "Retrieve album images for user (User identity: %s)";

    public static final String RETRIEVE_POST_TEMPLATE =
            "Retrieve post (Post identity: %s)";

    public static final String RETRIEVE_LIKES_A_POST_USER_COUNT_TEMPLATE =
            "Retrieve likes a post users count (Post identity: %s)";

    public static final String RETRIEVE_DISLIKES_A_POST_USER_COUNT_TEMPLATE =
            "Retrieve dislikes a post users count (Post identity: %s)";

    public static final String RETRIEVE_STARS_A_POST_USER_COUNT_TEMPLATE =
            "Retrieve stars a post users count (Post identity: %s)";

    public static final String RETRIEVE_USER_IDENTITIES_WHO_LIKED_THE_POST_TEMPLATE =
            "Retrieve users' identities who liked the post (Post identity: %s)";

    public static final String RETRIEVE_USER_IDENTITIES_WHO_DISLIKED_THE_POST_TEMPLATE =
            "Retrieve users' identities who disliked the post (Post identity: %s)";

    public static final String RETRIEVE_USER_IDENTITIES_WHO_STARED_THE_POST_TEMPLATE =
            "Retrieve users' identities who stared the post (Post identity: %s)";

    public static final String RETRIEVE_LIKES_A_COMMENT_USER_COUNT_TEMPLATE =
            "Retrieve likes a comment users count (Post identity: %s)";

    public static final String RETRIEVE_DISLIKES_A_COMMENT_USER_COUNT_TEMPLATE =
            "Retrieve dislikes a comment users count (Post identity: %s)";

    public static final String RETRIEVE_POSTS_FOR_USER_TEMPLATE =
            "Retrieve Posts for user (User identity: %s)";

    public static final String RETRIEVE_USER_FRIENDS_TEMPLATE =
            "Retrieve user friends (User identity: %s)";

    public static final String RETRIEVE_USER_FRIENDSHIP_REQUESTS_TEMPLATE =
            "Retrieve user friendship requests (User identity: %s)";

    public static final String RETRIEVE_USER_NOTIFICATIONS_TEMPLATE =
            "Retrieve user notifications (user identity: %s)";

    private LoggerConstants() {
    }
}
