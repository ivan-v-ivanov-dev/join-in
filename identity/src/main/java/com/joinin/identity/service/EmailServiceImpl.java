package com.joinin.identity.service;

import com.joinin.identity.repository.EmailRepository;
import com.joinin.identity.service.contract.EmailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class EmailServiceImpl implements EmailService {

    private final EmailRepository emailRepository;

    @Override
    public boolean isEmailUnique(String email) {
        boolean isEmailUnique = emailRepository.existsByEmail(email);
        log.info("Check whether email is unique: " + email + ": " + isEmailUnique);
        return isEmailUnique;
    }

    @Override
    public String retrieveEmailByIdentity(String identity) {
        String email = emailRepository.retrieveEmailByIdentity(identity);
        log.info("Retrieve email by identity: " + email);
        return email;
    }
}
