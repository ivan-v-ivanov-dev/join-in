package com.social.mvc.service.constants;

public class LoggerConstants {

    public static final String USER_LOGGED_TEMPLATE = "User logged: %s";

    public static final String PROFILE_INFORMATION_RETRIEVED_FOR_USER_TEMPLATE =
            "ProfileRq information retrieved for User %s";

    public static final String RETRIEVE_PROFILE_IMAGE_FROM_GATEWAY_SERVICE_TEMPLATE =
            "Retrieve ProfileRq image from Gateway API Service (ProfileRq identity: %s)";

    public static final String RETRIEVE_PROFILE_BACKGROUND_IMAGE_FROM_GATEWAY_SERVICE_TEMPLATE =
            "Retrieve ProfileRq background image from Gateway API Service (ProfileRq identity: %s)";

    public static final String RETRIEVE_ALBUM_IMAGES_FOR_USER_TEMPLATE =
            "Retrieve album images for user (ProfileRq identity: %s)";

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
