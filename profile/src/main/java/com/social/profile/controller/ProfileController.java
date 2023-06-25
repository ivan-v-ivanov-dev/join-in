package com.social.profile.controller;


import com.social.profile.model.Profile;
import com.social.profile.service.contrancts.ProfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/health")
    public String health() {
        return "Profile service is HEALTHY.";
    }

    @PostMapping("/")
    public Profile profile(@RequestParam("identity") String identity) {
        return this.profileService.findByIdentity(identity);
    }
}
