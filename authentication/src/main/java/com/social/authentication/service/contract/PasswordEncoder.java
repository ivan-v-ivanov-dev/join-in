package com.social.authentication.service.contract;

public interface PasswordEncoder {

    boolean areEqual(String queryPassword, String databasePassword);

    String encode(String password);
}
