package com.social.profile.service.constants;

public class LoggerConstants {

    public static final String KAFKA_MESSAGE_FOR_NEW_REGISTERED_USER_CREATED_AND_SEND_TO_AUTHENTICATION_SERVICE_IN_TOPIC_TEMPLATE =
            "Kafka Message for new registered user (Profile identity: %s) created and send to Authentication service (Kafka topic: %s)";
    public static final String NEW_REGISTERED_USER_PROFILE_SAVED_IN_DATABASE_TEMPLATE =
            "New registered user (Profile identity: %s) saved in database";

    public static final String KAFKA_MESSAGE_FOR_NEW_POST_CREATED_AND_SEND_TO_POST_SERVICE_IN_TOPIC_TEMPLATE =
            "Kafka Message for new post (posted by Profile %s) created and send to Post service (Kafka topic: %s)";

    public static final String KAFKA_MESSAGE_FOR_NEW_COMMENT_CREATED_AND_SEND_TO_POST_SERVICE_IN_TOPIC_TEMPLATE =
            "Kafka Message for new comment (posted by Profile %s) created and send to Post service (Kafka topic: %s)";

    private LoggerConstants() {
    }
}
