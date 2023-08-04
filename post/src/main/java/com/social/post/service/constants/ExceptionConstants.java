package com.social.post.service.constants;

public class ExceptionConstants {

    private static final String RELATIONSHIP_OR_REACTION_OR_IMAGE_SERVICE = "Relationship | Reaction | Image Service :: ";

    private static final String IMAGE_SERVICE = "Image Service :: ";

    private static final String RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN =
            "Resource not available or service is down";

    public static final String RELATIONSHIP_OR_REACTION_OR_IMAGE_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN =
            RELATIONSHIP_OR_REACTION_OR_IMAGE_SERVICE + RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN;

    public static final String IMAGE_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN =
            IMAGE_SERVICE + RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN;


    private ExceptionConstants() {

    }
}
