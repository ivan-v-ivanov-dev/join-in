package com.social.authentication.service;

import com.social.authentication.service.contract.PasswordEncoder;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PasswordEncoderImpl implements PasswordEncoder {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public boolean areEqual(String queryPassword, String databasePassword) {
        return bCryptPasswordEncoder.matches(queryPassword, databasePassword);
    }

    public String encode(String password) {
        return bCryptPasswordEncoder.encode(password);
    }
}
