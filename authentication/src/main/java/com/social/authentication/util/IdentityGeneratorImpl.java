package com.social.authentication.util;

import com.social.authentication.util.contracts.IdentityGenerator;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Component
public class IdentityGeneratorImpl implements IdentityGenerator {

    private static final String SHA_512 = "SHA-512";

    public String generate(String email) {
        String toHash = UUID.randomUUID() + email + UUID.randomUUID();
        StringBuilder checksum = new StringBuilder();

        try {
            MessageDigest messageDigest = MessageDigest.getInstance(SHA_512);
            byte[] checksumBytes = messageDigest.digest(toHash.getBytes());

            for (byte currentByte : checksumBytes) {
                checksum.append(String.format("%02x", currentByte));
            }

        } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            noSuchAlgorithmException.printStackTrace();
        }

        return checksum.toString();
    }
}
