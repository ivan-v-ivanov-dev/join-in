package com.social.post.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class IdentityGeneratorImplTest {

    @InjectMocks
    IdentityGeneratorImpl identityGenerator;

    @Test
    public void generate_should_calculateChecksum() throws NoSuchAlgorithmException {
        String userIdentity = "userIdentity";
        String content = "content";
        String createDate = LocalDate.now().toString();

        String result = identityGenerator.generate(userIdentity, content, createDate);

        String toHash = String.format("%s_%s_%s", userIdentity, content, createDate);
        StringBuilder expected = new StringBuilder();
        MessageDigest messageDigestResult = MessageDigest.getInstance("SHA-512");
        byte[] checksumBytes = messageDigestResult.digest(toHash.getBytes());

        for (byte currentByte : checksumBytes) {
            expected.append(String.format("%02x", currentByte));
        }

        assertEquals(expected.toString(), result);
    }
}
