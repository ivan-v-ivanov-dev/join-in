package com.social.post.config;

public class ConfigConstants {

    // Redis Configuration Logger Constants
    public static final String REDIS_CONFIGURATION = "Redis Configuration :: ";
    public static final String REDIS_CONFIGURATION_REDIS_STANDALONE_CONFIGURATION_CREATED = REDIS_CONFIGURATION +
            "RedisStandaloneConfiguration Created";
    public static final String REDIS_CONFIGURATION_JEDIS_CONNECTION_FACTORY_CREATED = REDIS_CONFIGURATION +
            "JedisConnectionFactory Created";
    public static final String REDIS_CONFIGURATION_OBJECT_MAPPER_CREATED = REDIS_CONFIGURATION +
            "ObjectMapper Created";
    public static final String REDIS_CONFIGURATION_JACKSON_2_JSON_REDIS_SERIALIZER_CREATED = REDIS_CONFIGURATION +
            "Jackson2JsonRedisSerializer Created";
    public static final String REDIS_CONFIGURATION_REDIS_TEMPLATE_CREATED = REDIS_CONFIGURATION +
            "RedisTemplate Created";

    // Mongo Configuration Logger Constants
    public static final String MONGO_CONFIGURATION = "Mongo Configuration :: ";
    public static final String CREATE_MONGO_CLIENT = MONGO_CONFIGURATION + "Create Mongo Client";
    public static final String CREATE_MONGO_TEMPLATE = MONGO_CONFIGURATION + "Create Mongo Template";

    // Kafka Configuration Logger Constants
    public static final String KAFKA_CONFIGURATION = "Kafka Config :: ";
    public static final String KAFKA_CONFIGURATION_CREATE_DEFAULT_CONSUMER_FACTORY_FOR_KAFKA_MESSAGE =
            KAFKA_CONFIGURATION + " Create Default Consumer Factory for Kafka Message";
    public static final String KAFKA_CONFIGURATION_CREATE_CONCURRENT_KAFKA_LISTENER_CONTAINER_FACTORY =
            KAFKA_CONFIGURATION + " Create Concurrent Kafka Listener Container Factor for Kafka Message";

}
