package com.social.profile.config;

public class ConfigConstants {

    // MongoDB Configurations
    private static final String MONGO_CONFIGURATIONS = "Mongo Configurations :: ";

    public static final String MONGO_CLIENT_CREATED = MONGO_CONFIGURATIONS + "Mongo Client created";

    public static final String MONGO_TEMPLATE_CREATED = MONGO_CONFIGURATIONS + "Mongo Template created";

    // Kafka Configurations
    private static final String KAFKA_CONFIGURATIONS = "Kafka Configurations :: ";

    private static final String FOR_KAFKA_MESSAGING_CREATED = " for Kafka messaging created";

    public static final String DEFAULT_PRODUCER_FACTORY_FOR_KAFKA_MESSAGING_CREATED =
            KAFKA_CONFIGURATIONS + "Default Producer Factory" + FOR_KAFKA_MESSAGING_CREATED;

    public static final String KAFKA_TEMPLATE_FOR_KAFKA_MESSAGING_CREATED =
            KAFKA_CONFIGURATIONS + "Kafka Template" + FOR_KAFKA_MESSAGING_CREATED;

    public static final String DEFAULT_CONSUMER_FACTORY_FOR_KAFKA_MESSAGING_CREATED =
            KAFKA_CONFIGURATIONS + "Default Consumer Factory" + FOR_KAFKA_MESSAGING_CREATED;

    public static final String CONCURRENT_KAFKA_LISTENER_CONTAINER_FACTORY_FOR_KAFKA_MESSAGING_CREATED =
            KAFKA_CONFIGURATIONS + "Concurrent Kafka Listener Container Factor" + FOR_KAFKA_MESSAGING_CREATED;

    // Kafka Topic constants
    private static final String KAFKA_TOPIC_NEW_TOPIC_FOR = "Kafka Topic :: New topic for ";

    private static final String CREATED_TOPIC_NAME = " created (name:  %s)";

    public static final String KAFKA_TOPIC_FOR_NEW_REGISTERED_USERS_CREATED_TEMPLATE =
            KAFKA_TOPIC_NEW_TOPIC_FOR + "new registered users" + CREATED_TOPIC_NAME;

    public static final String KAFKA_TOPIC_FOR_NEW_POSTS_CREATED_TEMPLATE =
            KAFKA_TOPIC_NEW_TOPIC_FOR + "new posts" + CREATED_TOPIC_NAME;

    public static final String KAFKA_TOPIC_FOR_NEW_COMMENTS_CREATED_TEMPLATE =
            KAFKA_TOPIC_NEW_TOPIC_FOR + "new comments" + CREATED_TOPIC_NAME;

    public static final String KAFKA_TOPIC_TO_DELETE_POSTS_TEMPLATE =
            KAFKA_TOPIC_NEW_TOPIC_FOR + "deleting posts" + CREATED_TOPIC_NAME;

    public static final String KAFKA_TOPIC_FOR_EDIT_POST_TEMPLATE =
            KAFKA_TOPIC_NEW_TOPIC_FOR + "edit post" + CREATED_TOPIC_NAME;

    public static final String KAFKA_TOPIC_FOR_LIKE_POST_TEMPLATE =
            KAFKA_TOPIC_NEW_TOPIC_FOR + "like post" + CREATED_TOPIC_NAME;

    public static final String KAFKA_TOPIC_FOR_ACCEPT_FRIENDSHIP_TEMPLATE =
            KAFKA_TOPIC_NEW_TOPIC_FOR + "accept friendship" + CREATED_TOPIC_NAME;

    private ConfigConstants() {
    }
}
