package com.joinin.identity.service.contract;

public interface EmailService {
    boolean isEmailUnique(String email);

    String retrieveEmailByIdentity(String identity);
}
