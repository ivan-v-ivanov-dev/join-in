package com.social.authentication.service;

import com.social.authentication.service.contract.IdentityGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IdentityGeneratorImplTest {

    private final IdentityGenerator identityGenerator = new IdentityGeneratorImpl();

    @Test
    public void testGenerateWithValidEmail() {
        String email = "test@example.com";
        String expectedHash = "973dfe463ec85785f5f95af5ba3906eedb2d931c24e69824a89ea65dba4e813b";

        String actualHash = identityGenerator.generate(email);

        assertEquals(expectedHash, actualHash);
    }
}
