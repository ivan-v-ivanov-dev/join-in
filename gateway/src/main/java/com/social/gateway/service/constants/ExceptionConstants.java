package com.social.gateway.service.constants;

public class ExceptionConstants {

    private static final String AUTHENTICATION_SERVICE = "Authentication Service :: ";

    private static final String IMAGE_SERVICE = "Image Service :: ";

    private static final String POST_SERVICE = "Post Service :: ";

    private static final String PROFILE_SERVICE = "Profile Service :: ";

    private static final String RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN =
            "Resource not available or service is down";

    public static final String AUTHENTICATION_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN =
            AUTHENTICATION_SERVICE + RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN;

    public static final String IMAGE_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN =
            IMAGE_SERVICE + RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN;

    public static final String POST_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN =
            POST_SERVICE + RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN;

    public static final String PROFILE_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN =
            PROFILE_SERVICE + RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN;

    private ExceptionConstants() {
    }
}
