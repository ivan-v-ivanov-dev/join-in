package com.social.reaction.service.constants;

public class LoggerConstants {

    public static final String NEW_REGISTERED_USER_MESSAGE_RECEIVED_FROM_API_GATEWAY_SERVICE_TEMPLATE =
            "Kafka Messaging :: New registered user received from API Gateway service (Kafka topic: %s, User identity: %s)";

    public static final String NEW_USER_SAVED_IN_DATABASE_TEMPLATE =
            "New user saved in database (User identity: %s)";

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

    public static final String RETRIEVE_LIKES_A_COMMENT_USER_COUNT_COMMENT_TEMPLATE =
            "Retrieve likes a comment users count (Comment identity: %s)";

    public static final String RETRIEVE_DISLIKES_A_COMMENT_USER_COUNT_COMMENT_TEMPLATE =
            "Retrieve dislikes a comment users count (Comment identity: %s)";


    private LoggerConstants(){}
}
