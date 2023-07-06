package com.social.profile.config;

public class ConfigConstants {

    // MongoDB Configurations
    public static final String CREATE_MONGO_CLIENT = "Mongo Config :: Create Mongo Client";

    public static final String CREATE_MONGO_TEMPLATE = "Mongo Config :: Create Mongo Template";

    // Kafka Configurations
    public static final String KAFKA_CONFIG_CREATE_DEFAULT_PRODUCER_FACTORY_FOR_KAFKA_MESSAGE =
            "Kafka Config :: Create Default Producer Factory for Kafka Message";

    public static final String KAFKA_CONFIG_CREATE_KAFKA_TEMPLATE_FOR_KAFKA_MESSAGE =
            "Kafka Config :: Create Kafka Template for Kafka Message";

    public static final String KAFKA_CONFIG_CREATE_DEFAULT_CONSUMER_FACTORY_FOR_KAFKA_MESSAGE =
            "Kafka Config :: Create Default Consumer Factory for Kafka Message";

    public static final String KAFKA_CONFIG_CREATE_CONCURRENT_KAFKA_LISTENER_CONTAINER_FACTORY =
            "Kafka Config :: Create Concurrent Kafka Listener Container Factor for Kafka Message";

    // Kafka Topic
    public static final String KAFKA_TOPIC_CREATE_TOPIC_FOR_NEW_REGISTERED_USER_TEMPLATE =
            "Kafka Topic :: Create Kafka Topic (%s) for new registered users to send messages to Profile service";

    private ConfigConstants() {
    }
}
