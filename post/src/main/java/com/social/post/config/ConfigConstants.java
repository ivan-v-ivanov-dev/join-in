package com.social.post.config;

public class ConfigConstants {

    // Redis Configuration Logger Constants
    private static final String REDIS_CONFIGURATION = "Redis Configuration :: ";

    private static final String CREATED = " created";

    public static final String REDIS_CONFIGURATION_REDIS_STANDALONE_CONFIGURATION_CREATED =
            REDIS_CONFIGURATION + "Redis Standalone Configuration" + CREATED;

    public static final String REDIS_CONFIGURATION_JEDIS_CONNECTION_FACTORY_CREATED =
            REDIS_CONFIGURATION + "Jedis Connection Factory" + CREATED;

    public static final String REDIS_CONFIGURATION_OBJECT_MAPPER_CREATED =
            REDIS_CONFIGURATION + "ObjectMapper" + CREATED;

    public static final String REDIS_CONFIGURATION_JACKSON_2_JSON_REDIS_SERIALIZER_CREATED =
            REDIS_CONFIGURATION + "Jackson 2 Json Redis Serializer" + CREATED;

    public static final String REDIS_CONFIGURATION_REDIS_TEMPLATE_CREATED =
            REDIS_CONFIGURATION + "Redis Template" + CREATED;

    // Mongo Configuration Logger Constants
    private static final String MONGO_CONFIGURATION = "Mongo Configuration :: ";

    public static final String MONGO_CLIENT_CREATED = MONGO_CONFIGURATION + "Mongo Client" + CREATED;

    public static final String MONGO_TEMPLATE_CREATED = MONGO_CONFIGURATION + "Mongo Template" + CREATED;

    // Kafka Configuration Logger Constants
    private static final String KAFKA_CONFIGURATION = "Kafka Configuration :: ";

    private static final String FOR_KAFKA_MESSAGING_CREATED = " for Kafka messaging created";

    public static final String DEFAULT_PRODUCER_FACTORY_FOR_KAFKA_MESSAGING_CREATED =
            KAFKA_CONFIGURATION + "Default Producer Factory" + FOR_KAFKA_MESSAGING_CREATED;

    public static final String KAFKA_TEMPLATE_FOR_KAFKA_MESSAGING_CREATED =
            KAFKA_CONFIGURATION + "Kafka Template" + FOR_KAFKA_MESSAGING_CREATED;

    public static final String DEFAULT_CONSUMER_FACTORY_FOR_KAFKA_MESSAGING_CREATED =
            KAFKA_CONFIGURATION + "Default Consumer Factory" + FOR_KAFKA_MESSAGING_CREATED;

    public static final String CONCURRENT_KAFKA_LISTENER_CONTAINER_FACTORY_FOR_KAFKA_MESSAGING_CREATED =
            KAFKA_CONFIGURATION + "Concurrent Kafka Listener Container Factor" + FOR_KAFKA_MESSAGING_CREATED;

    // Kafka Topics
    private static final String KAFKA_TOPIC_NEW_TOPIC_FOR = "Kafka Topic :: New topic for ";

    private static final String CREATED_TOPIC_NAME = " created (name:  %s)";

    public static final String KAFKA_TOPIC_FOR_NEW_POST_NOTIFICATIONS_CREATED_TEMPLATE =
            KAFKA_TOPIC_NEW_TOPIC_FOR + "new posts notifications" + CREATED_TOPIC_NAME;

    public static final String KAFKA_TOPIC_FOR_NEW_COMMENT_NOTIFICATIONS_CREATED_TEMPLATE =
            KAFKA_TOPIC_NEW_TOPIC_FOR + "new comment notifications" + CREATED_TOPIC_NAME;

    public static final String KAFKA_TOPIC_FOR_NEW_POST_NODE_CREATED_TEMPLATE =
            KAFKA_TOPIC_NEW_TOPIC_FOR + "new post node" + CREATED_TOPIC_NAME;

    public static final String KAFKA_TOPIC_FOR_NEW_COMMENT_NODE_CREATED_TEMPLATE =
            KAFKA_TOPIC_NEW_TOPIC_FOR + "new comment node" + CREATED_TOPIC_NAME;

    public static final String KAFKA_TOPIC_FOR_DELETING_NODES_CREATED_TEMPLATE =
            KAFKA_TOPIC_NEW_TOPIC_FOR + "deleting nodes" + CREATED_TOPIC_NAME;
}
