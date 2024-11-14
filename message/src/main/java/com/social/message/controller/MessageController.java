package com.social.message.controller;

import com.social.message.service.contracts.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @GetMapping("/profile/{identity}/online-status")
    public boolean findUserOnlineStatus(@PathVariable("identity") String identity) {
        return messageService.findUserOnlineStatus(identity);
    }

    @GetMapping("/health")
    public String health() {
        return "Message service is HEALTHY";
    }
}
