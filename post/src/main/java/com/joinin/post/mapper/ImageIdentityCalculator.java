package com.joinin.post.mapper;

import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.HexFormat;

@Service
public class ImageIdentityCalculator {

    public String generateImageIdentity(byte[] imageBytes) {

        if (imageBytes == null || imageBytes.length == 0) {
            return null;
        }

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");

            digest.update(imageBytes);
            digest.update(
                    LocalDateTime.now()
                            .toString()
                            .getBytes(StandardCharsets.UTF_8));

            return HexFormat.of().formatHex(digest.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("Unable to generate image identity", e);
        }
    }
}
