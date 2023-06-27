package com.social.authentication.util;

import com.social.authentication.util.contracts.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoderImpl implements PasswordEncoder {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public PasswordEncoderImpl() {
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    public boolean areEqual(String queryPassword, String databasePassword) {
        return bCryptPasswordEncoder.matches(queryPassword, databasePassword);
    }

    public String encode(String password) {
        return bCryptPasswordEncoder.encode(password);
    }
}
