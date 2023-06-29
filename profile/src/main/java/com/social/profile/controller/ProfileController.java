package com.social.profile.controller;

import com.social.profile.model.Profile;
import com.social.profile.service.contrancts.ProfileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/")
    public String profile(@RequestParam("identity") String identity, Model model) {
        Profile byIdentity = this.profileService.findByIdentity(identity);
        model.addAttribute("profile", this.profileService.findByIdentity(identity));
        return "profile";
    }

    @GetMapping("/health")
    public String health() {
        return "Profile service is HEALTHY.";
    }
}
