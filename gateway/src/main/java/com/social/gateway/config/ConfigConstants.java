package com.social.gateway.config;

public class ConfigConstants {

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

    public static final String KAFKA_TOPIC_FOR_LOGOUT_USER_TEMPLATE =
            KAFKA_TOPIC_NEW_TOPIC_FOR + "logout user" + CREATED_TOPIC_NAME;

    public static final String KAFKA_TOPIC_FOR_LOGIN_USER_CREATED_TEMPLATE =
            "Kafka Topic :: New topic for login user created (name:  %s)";


    private ConfigConstants() {
    }
}
