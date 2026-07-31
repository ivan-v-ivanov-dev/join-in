package com.joinin.message.controller;

import com.join_in.common_models.ProfileOnlineStatusRpMessageService;
import com.joinin.message.service.contract.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class MessageController {

    private final ProfileService profileService;

    @PostMapping("/profiles/online-status")
    public List<ProfileOnlineStatusRpMessageService> retrieveProfilesOnlineStatuses(@RequestBody List<String> identities) {
        return profileService.retrieveProfilesOnlineStatuses(identities);
    }
}
