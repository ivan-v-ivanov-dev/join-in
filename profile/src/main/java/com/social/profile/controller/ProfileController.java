package com.social.profile.controller;

import com.social.model.dto.ProfileRp;
import com.social.profile.service.contract.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping("/profile/{identity}")
    public ProfileRp findByIdentity(@PathVariable("identity") String identity) {
        return profileService.findByIdentity(identity);
    }

    @GetMapping("/health")
    public String health() {
        return "Profile service is HEALTHY.";
    }
}
