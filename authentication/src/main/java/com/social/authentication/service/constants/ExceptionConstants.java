package com.social.authentication.service.constants;

public class ExceptionConstants {

    public static final String BAD_CREDENTIALS = "Bad credentials";

    public static final String USER_ALREADY_EXISTS = "User already exists";

    public static final String USER_ALREADY_EXISTS_WITH_EMAIL_TEMPLATE =
            USER_ALREADY_EXISTS + " with email: %s";

    private ExceptionConstants() {
    }
}
