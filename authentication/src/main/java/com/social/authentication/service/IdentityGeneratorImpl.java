package com.social.authentication.service;

import com.social.authentication.service.contract.IdentityGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static com.social.authentication.service.constants.LoggerConstants.IDENTITY_CALCULATED_FOR_USER_TEMPLATE;
import static java.lang.String.format;

@Service
@Slf4j
public class IdentityGeneratorImpl implements IdentityGenerator {

    public String generate(String email) {
        StringBuffer encoded = new StringBuffer();

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(email.getBytes(StandardCharsets.UTF_8));

            encoded = new StringBuffer(2 * hashBytes.length);

            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    encoded.append('0');
                }
                encoded.append(hex);
            }

            log.info(format(IDENTITY_CALCULATED_FOR_USER_TEMPLATE, email));
        } catch (NoSuchAlgorithmException exception) {
            log.error(exception.toString());

        }

        return encoded.toString();
    }
}
