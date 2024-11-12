package com.social.mvc.service.constants;

public class ExceptionConstants {

    private static final String GATEWAY_SERVICE = "Gateway API Service :: ";

    private static final String RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN =
            "Resource not available or service is down";

    public static final String GATEWAY_SERVICE_RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN =
            GATEWAY_SERVICE + RESOURCE_NOT_AVAILABLE_OR_SERVICE_IS_DOWN;

    private ExceptionConstants() {
    }
}
