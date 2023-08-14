package com.social.message.controller;

import com.social.message.model.DirectChat;
import com.social.message.model.User;
import com.social.message.service.contract.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/friends/online")
    public Set<User> findUserOnlineFriends(@RequestParam("identity") String identity) {
        return messageService.findUserOnlineFriends(identity);
    }

    @PostMapping("/direct-chat/history")
    public Set<DirectChat> findUserDirectChatHistory(@RequestParam("identity") String identity) {
        return messageService.findUserDirectChatHistory(identity);
    }

    @GetMapping("/health")
    public String health() {
        return "Message service is HEALTHY";
    }
}
