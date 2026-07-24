package com.joinin.identity.controller;

import com.joinin.identity.service.contract.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class IdentityServiceController {

    private final EmailService emailService;

    @PostMapping("/email/{email}/unique")
    public boolean isEmailUnique(@PathVariable("email") String email) {
        return emailService.isEmailUnique(email);
    }

    @GetMapping("/identity/{identity}/email")
    public String retrieveEmailByIdentity(@PathVariable String identity) {
        return emailService.retrieveEmailByIdentity(identity);
    }
}
