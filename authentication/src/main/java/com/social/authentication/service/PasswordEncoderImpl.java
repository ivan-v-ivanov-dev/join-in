package com.social.authentication.service;

import com.social.authentication.service.contract.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
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
