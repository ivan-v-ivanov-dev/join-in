package com.social.profile.service.constants;

public class ModelEntityConstants {

    public static final String NAME_CAN_NOT_BE_EMPTY = "Name can not be empty!";
    public static final String NAME_MUST_BE_BETWEEN_3_AND_30_SYMBOLS = "Name must be between 2 and 30 symbols!";
    public static final String EMAIL_CAN_NOT_BE_EMPTY = "Email can not be empty!";
    public static final String EMAIL_REG_EX_PATTERN = "[A-Za-z]+@[A-Za-z]+[.][A-Za-z]+";
    public static final String EMAIL_EXAMPLE = "Email must contain @! Example: some@some.com";
    public static final String PASSWORD_CAN_NOT_BE_EMPTY = "Password can not be empty!";
    public static final String PASSWORD_MUST_BE_AT_LEAST_8_SYMBOLS = "Password must be at least 8 symbols!";

    private ModelEntityConstants() {
    }
}
