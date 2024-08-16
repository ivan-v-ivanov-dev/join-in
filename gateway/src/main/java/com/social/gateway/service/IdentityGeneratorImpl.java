package com.social.gateway.service;

import com.social.gateway.service.contract.IdentityGenerator;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Service
public class IdentityGeneratorImpl implements IdentityGenerator {

    private static final String SHA_256 = "SHA-256";

    public String generate(String email) {
        String toHash = UUID.randomUUID() + email + UUID.randomUUID();
        StringBuilder checksum = new StringBuilder();

        try {
            MessageDigest messageDigest = MessageDigest.getInstance(SHA_256);
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
