package com.social.reaction.config;

public class ConfigConstants {

    private static final String KAFKA_CONFIGURATION = "Kafka Configurations :: ";

    private static final String FOR_KAFKA_MESSAGING_CREATED = " for Kafka messaging created";

    public static final String DEFAULT_PRODUCER_FACTORY_FOR_KAFKA_MESSAGING_CREATED =
            KAFKA_CONFIGURATION + "Default Producer Factory" + FOR_KAFKA_MESSAGING_CREATED;

    public static final String KAFKA_TEMPLATE_FOR_KAFKA_MESSAGING_CREATED =
            KAFKA_CONFIGURATION + "Kafka Template" + FOR_KAFKA_MESSAGING_CREATED;

    public static final String DEFAULT_CONSUMER_FACTORY_FOR_KAFKA_MESSAGING_CREATED =
            KAFKA_CONFIGURATION + "Default Consumer Factory" + FOR_KAFKA_MESSAGING_CREATED;

    public static final String CONCURRENT_KAFKA_LISTENER_CONTAINER_FACTORY_FOR_KAFKA_MESSAGING_CREATED =
            KAFKA_CONFIGURATION + "Concurrent Kafka Listener Container Factor" + FOR_KAFKA_MESSAGING_CREATED;

    // Kafka Topic
    public static final String KAFKA_TOPIC_FOR_LIKE_A_POST_CREATED_TEMPLATE =
            "Kafka Topic :: New topic for like a post created (name:  %s)";

   public static final String KAFKA_TOPIC_FOR_DISLIKE_A_POST_CREATED_TEMPLATE =
            "Kafka Topic :: New topic for dislike a post created (name:  %s)";

   public static final String KAFKA_TOPIC_FOR_STAR_A_POST_CREATED_TEMPLATE =
            "Kafka Topic :: New topic for star a post created (name:  %s)";

    private ConfigConstants() {
    }
}
