package com.social.authentication.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static com.social.authentication.config.ConfigConstants.B_CRYPT_PASSWORD_ENCODER_CREATED;

@Configuration
@Slf4j
public class BCryptPasswordEncoderConfig {

    @Bean
    public BCryptPasswordEncoder createBCryptPasswordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        log.info(B_CRYPT_PASSWORD_ENCODER_CREATED);
        return bCryptPasswordEncoder;
    }
}
