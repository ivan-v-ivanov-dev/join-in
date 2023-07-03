package com.social.authentication.config;

public class ConfigConstants {

    public static final String KAFKA_CONFIG_CREATE_DEFAULT_PRODUCER_FACTORY_FOR_KAFKA_MESSAGE =
            "Kafka Config :: Create Default Producer Factory for Kafka Message";

    public static final String KAFKA_CONFIG_CREATE_KAFKA_TEMPLATE_FOR_KAFKA_MESSAGE =
            "Kafka Config :: Create Kafka Template for Kafka Message";

    public static final String KAFKA_TOPIC_CREATE_TOPIC_FOR_NEW_REGISTERED_USER_TEMPLATE =
            "Kafka Topic :: Create Kafka Topic (%s) for new registered users to send messages to Profile service";

    private ConfigConstants() {

    }
}
