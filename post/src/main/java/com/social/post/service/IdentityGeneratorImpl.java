package com.social.post.service;

import com.social.post.service.contracts.IdentityGenerator;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static com.social.post.service.constants.IdentityConstants.*;

@Service
public class IdentityGeneratorImpl implements IdentityGenerator {

    public String generate(String userIdentity, String content, String createDate) {
        String toHash = String.format(TO_HASH_STRING_TEMPLATE, userIdentity, content, createDate);
        StringBuilder checksum = new StringBuilder();

        try {
            MessageDigest messageDigest = MessageDigest.getInstance(SHA_512);
            byte[] checksumBytes = messageDigest.digest(toHash.getBytes());

            for (byte currentByte : checksumBytes) {
                checksum.append(String.format(CHECKSUM_TEMPLATE_FORMAT, currentByte));
            }

        } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            noSuchAlgorithmException.printStackTrace();
        }

        return checksum.toString();
    }
}
