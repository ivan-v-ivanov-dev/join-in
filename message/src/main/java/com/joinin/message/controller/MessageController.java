package com.joinin.message.controller;

import com.join_in.common_models.ConversationRpMessageService;
import com.join_in.common_models.ProfileOnlineStatusRpMessageService;
import com.joinin.message.model.ChatMessage;
import com.joinin.message.model.MessageByConversation;
import com.joinin.message.service.contract.MessageService;
import com.joinin.message.service.contract.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class MessageController {

    private final ProfileService profileService;
    private final MessageService messageService;

    @PostMapping("/profiles/online-status")
    public List<ProfileOnlineStatusRpMessageService> retrieveProfilesOnlineStatuses(@RequestBody List<String> identities) {
        return profileService.retrieveProfilesOnlineStatuses(identities);
    }

    @GetMapping("/profile/{identity}/conversations")
    public List<ConversationRpMessageService> retrieveConversations(@PathVariable("identity") String identity) {
        return messageService.retrieveConversations(identity);
    }

    @GetMapping("/conversation/{identity}/messages")
    public List<ChatMessage> retrieveConversationMessages(@PathVariable("identity") String identity) {
        return messageService.retrieveConversationMessages(identity);
    }
}
