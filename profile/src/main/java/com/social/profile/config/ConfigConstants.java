package com.social.profile.config;

public class ConfigConstants {

    // MongoDB Configurations
    private static final String MONGO_CONFIGURATIONS = "Mongo Configurations :: ";

    public static final String MONGO_CLIENT_CREATED = MONGO_CONFIGURATIONS + "Mongo Client created";

    public static final String MONGO_TEMPLATE_CREATED = MONGO_CONFIGURATIONS + "Mongo Template created";

    // Kafka Configurations
    private static final String KAFKA_CONFIGURATIONS = "Kafka Configurations :: ";

    private static final String FOR_KAFKA_MESSAGING_CREATED = " for Kafka messaging created";

    public static final String DEFAULT_CONSUMER_FACTORY_FOR_KAFKA_MESSAGING_CREATED =
            KAFKA_CONFIGURATIONS + "Default Consumer Factory" + FOR_KAFKA_MESSAGING_CREATED;

    public static final String CONCURRENT_KAFKA_LISTENER_CONTAINER_FACTORY_FOR_KAFKA_MESSAGING_CREATED =
            KAFKA_CONFIGURATIONS + "Concurrent Kafka Listener Container Factor" + FOR_KAFKA_MESSAGING_CREATED;

    private ConfigConstants() {
    }
}
