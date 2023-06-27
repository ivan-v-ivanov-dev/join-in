package com.social.authentication.util.contracts;

public interface PasswordEncoder {

    boolean areEqual(String queryPassword, String databasePassword);

    String encode(String password);
}
