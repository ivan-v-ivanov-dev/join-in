package com.social.post.service.constants;

public class LoggerConstants {

    public static final String COLLECTION_TEMPLATE = "c_%s";

    public static final String NEW_REGISTERED_USER_MESSAGE_RECEIVED_FROM_API_GATEWAY_SERVICE_TEMPLATE =
            "Kafka Messaging :: New registered user received from API Gateway service (Kafka topic: %s, User identity: %s)";

    public static final String NEW_COLLECTION_CREATED_TEMPLATE =
            "New Collection created (Collection name: %s)";

    private LoggerConstants(){}
}
