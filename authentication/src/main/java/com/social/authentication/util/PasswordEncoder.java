package com.social.authentication.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoder {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public PasswordEncoder() {
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    public boolean areEqual(String queryPassword, String databasePassword) {
        return bCryptPasswordEncoder.matches(queryPassword, databasePassword);
    }
}
