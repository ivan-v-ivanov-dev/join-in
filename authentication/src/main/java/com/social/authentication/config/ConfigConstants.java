package com.social.authentication.config;

public class ConfigConstants {

    private static final String KAFKA_CONFIGURATIONS = "Kafka Configurations :: ";

    private static final String FOR_KAFKA_MESSAGING_CREATED = " for Kafka messaging created";

    public static final String DEFAULT_CONSUMER_FACTORY_FOR_KAFKA_MESSAGING_CREATED =
            KAFKA_CONFIGURATIONS + "Default Consumer Factory" + FOR_KAFKA_MESSAGING_CREATED;

    public static final String CONCURRENT_KAFKA_LISTENER_CONTAINER_FACTORY_FOR_KAFKA_MESSAGING_CREATED =
            KAFKA_CONFIGURATIONS + "Concurrent Kafka Listener Container Factor" + FOR_KAFKA_MESSAGING_CREATED;

    public static final String DEFAULT_PRODUCER_FACTORY_FOR_KAFKA_MESSAGING_CREATED =
            KAFKA_CONFIGURATIONS + "Default Producer Factory" + FOR_KAFKA_MESSAGING_CREATED;

    public static final String KAFKA_TEMPLATE_FOR_KAFKA_MESSAGING_CREATED =
            KAFKA_CONFIGURATIONS + "Kafka Template" + FOR_KAFKA_MESSAGING_CREATED;

    public static final String KAFKA_TOPIC_FOR_NEW_USER_CREATED_TEMPLATE =
            "Kafka Topic :: New topic for new user created (name:  %s)";

    public static final String KAFKA_TOPIC_FOR_LOGIN_USER_CREATED_TEMPLATE =
            "Kafka Topic :: New topic for login user created (name:  %s)";

    public static final String B_CRYPT_PASSWORD_ENCODER_CREATED =
            "BCryptPasswordEncoder :: New BCryptPasswordEncoder created";

    private ConfigConstants() {
    }
}
